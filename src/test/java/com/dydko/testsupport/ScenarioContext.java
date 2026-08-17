package com.dydko.testsupport;

public class ScenarioContext {

    private static final ThreadLocal<TestContext>
            CONTEXT = new ThreadLocal<>();

    public static void start() {
        CONTEXT.set(
                new TestContext()
        );
    }

    public static TestContext get() {
        TestContext context =
                CONTEXT.get();
        if (context == null) {
            throw new IllegalStateException(
                    "TestContext has not been initialized."
            );
        }
        return context;
    }

    public static void clear() {
        CONTEXT.remove();
    }
}