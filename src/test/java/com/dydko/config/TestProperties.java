package com.dydko.config;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class TestProperties {

    private static final Properties PROPS = new Properties();

    private TestProperties() {
    }

    static {
        String env = System.getProperty("env", "dev");
        String fileName = "application-" + env + ".properties";
        try (InputStream is =
                     TestProperties.class.getClassLoader().getResourceAsStream(fileName)) {
            if (is == null) {
                throw new IllegalStateException("Missing " + fileName);
            }
            PROPS.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Cannot load config for env=" + env, e);
        }
    }

    public static String get(String key) {
        // 1️⃣ -Dkey=value
        String sys = System.getProperty(key);
        if (sys != null && !sys.isBlank()) {
            return sys.trim();
        }

        // 2️⃣ ENV VAR (APP_BASEURL, TEST_USER_PASSWORD)
        String envKey = key.toUpperCase().replace('.', '_');
        String env = System.getenv(envKey);
        if (env != null && !env.isBlank()) {
            return env.trim();
        }

        // 3️⃣ application-dev.properties
        return PROPS.getProperty(key);
    }
}
