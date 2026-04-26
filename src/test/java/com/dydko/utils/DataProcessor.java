package com.dydko.utils;

import com.dydko.context.ScenarioContext;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class DataProcessor {

    private final ScenarioContext context;

    public String process(String value, Map<String, String> row) {

        if (value == null) return null;

        if (value.startsWith("$context.")) {
            String key = value.replace("$context.", "");
            return context.getAsString(key);
        }
        if (value.startsWith("$.")) {
            String key = value.replace("$.", "");
            return row.get(key);
        }

        if (value.startsWith("$pesel")) {

            String generated = DataUtils.generatePesel();

            // zapis do context
            if (value.contains("@")) {
                String contextKey = value.split("@")[1];
                context.set(contextKey, generated);
            }

            return generated;
        }

        // licznik np pesel#1
        if (value.contains("#")) {
            String key = value.split("#")[0];
            int count = context.increment(key);
            return key + count;
        }

        return value;
    }
}
