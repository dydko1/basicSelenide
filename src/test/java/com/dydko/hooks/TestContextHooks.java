package com.dydko.hooks;

import com.dydko.testsupport.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestContextHooks {

    @Before
    public void setUpContext() {

        ScenarioContext.start();
    }

    @After
    public void tearDownContext() {

        ScenarioContext.clear();
    }
}