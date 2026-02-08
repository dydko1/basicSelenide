package com.dydko.config;

public final class ConfigKeys {
    public static final class App {
        public static final String BASE_URL = "app.baseUrl";
    }

    public static final class Browser {
        public static final String NAME = "browser";
        public static final String TIMEOUT = "timeout";
        public static final String SIZE = "browser.size";
        public static final String HEADLESS = "headless";
    }

    public static final class TestData {
        public static final String USER_VALID = "test.user.valid";
        public static final String USER_INVALID = "test.user.invalid";
    }
}
