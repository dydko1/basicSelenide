package com.dydko.helper;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class AssertionHelper {

    public static void assertRowByKey(Map<String, Map<String, String>> table, String key, Map<String, String> expected) {
        Map<String, String> actual = table.get(key);

        if (actual == null) {
            throw new AssertionError("Row not found for key: " + key);
        }

        List<String> mismatches = expected.entrySet().stream()
                .filter(e -> !Objects.equals(actual.get(e.getKey()), e.getValue()))
                .map(e -> String.format(
                        "Column [%s] expected [%s] but was [%s]",
                        e.getKey(),
                        e.getValue(),
                        actual.get(e.getKey())
                ))
                .toList();

        if (!mismatches.isEmpty()) {
            throw new AssertionError(
                    "\nKey: " + key +
                            "\nMismatches:\n" + String.join("\n", mismatches) +
                            "\nActual row: " + actual
            );
        }
    }
}
