package com.dydko.steps;

import com.codeborne.selenide.Condition;
import com.dydko.pages.DynamicLoadingLesson05Page;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicLoadingLesson05Steps {

    private final DynamicLoadingLesson05Page page = new DynamicLoadingLesson05Page();

    @Given("user opens dynamic loading page - lesson 05")
    public void userOpensPage() {
        page.openPage();
    }

    @When("user starts loading")
    public void userStartsLoading() {
        page.clickStart();
    }

    @Then("Then hello world message is displayed")
    public void helloWorldMessageIsDisplayed() {
        page.getFinishText()
                .shouldBe(Condition.visible);
        assertThat(page.getFinishMessage())
                .isEqualTo("Hello World!");
    }
}