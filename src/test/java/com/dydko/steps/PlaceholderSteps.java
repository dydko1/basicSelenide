package com.dydko.steps;

import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlaceholderSteps {
    @Given("placeholder step aa")
    public void placeholder_step() {
        log.info("Tu był Miro !!!!!!!!!!!!!!!!!!");
    }
}
