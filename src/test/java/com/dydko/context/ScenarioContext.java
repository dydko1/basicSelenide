package com.dydko.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private final Map<String, Object> data = new HashMap<>();
    private final Map<String, Integer> counters = new HashMap<>();

    public void set(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public String getAsString(String key) {
        Object value = data.get(key);
        return value != null ? value.toString() : null;
    }

    public int increment(String key) {
        counters.putIfAbsent(key, 0);
        int value = counters.get(key) + 1;
        counters.put(key, value);
        return value;
    }
}
