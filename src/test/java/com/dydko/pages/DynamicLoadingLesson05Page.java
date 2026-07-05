package com.dydko.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

public class DynamicLoadingLesson05Page extends BasePage {

    private static final String URL =
            "https://the-internet.herokuapp.com/dynamic_loading/1";

    private final SelenideElement startButton =
            $("#start button");
    @Getter
    private final SelenideElement finishText =
            $("#finish");

    @Override
    protected String getUrl() {
        return URL;
    }

    public void clickStart() {
        startButton.click();
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return startButton;
    }

    public String getFinishMessage() {
        return finishText.getText();
    }
}