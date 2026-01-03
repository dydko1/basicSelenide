package com.dydko.config;

import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

    private static final Properties PROPS = new Properties();

    private TestProperties() {
    }

    static {
        try (InputStream is =
                     TestProperties.class.getClassLoader()
                             .getResourceAsStream("application.properties")) {
            if (is == null) {
                throw new IllegalStateException("application.properties not found");
            }
            PROPS.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Cannot load application.properties", e);
        }
    }

    public static String get(String key) {
        String fromSystem = System.getProperty(key);
        System.out.println("xxx "+fromSystem + "xxx");
        if (fromSystem != null && !fromSystem.isEmpty()) {
            return fromSystem.trim();
        }
        return PROPS.getProperty(key);
    }
}
