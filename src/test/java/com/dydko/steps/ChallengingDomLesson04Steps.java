package com.dydko.steps;

import com.dydko.pages.ChallengingDomLesson04Page;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class ChallengingDomLesson04Steps {

    private final ChallengingDomLesson04Page page = new ChallengingDomLesson04Page();

    @Given("user opens challenging dom lesson 04")
    public void userOpensChallengingDomLesson() {
        page.openPage();

    }

    @Then("table should contain rows")
    public void tableShouldContainRows() {
        int rows = page.getTable().getRowCount();
        assertThat(rows).isGreaterThan(0);
    }
}
