package com.dydko.testsupport;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private final Map<TestContextKey, Object> data =
            new HashMap<>();

    public <T> void set(
            TestContextKey key,
            T value) {

        data.put(key, value);
    }

    public <T> T get(
            TestContextKey key) {

        return (T) data.get(key);
    }

    public boolean contains(
            TestContextKey key) {

        return data.containsKey(key);
    }

    public void clear() {

        data.clear();
    }
}