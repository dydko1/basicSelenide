package com.dydko.pages;

import com.codeborne.selenide.SelenideElement;
import com.dydko.pages.components.ChallengingDomTableLesson04Component;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class ChallengingDomLesson04Page extends BasePage {

    private static final String URL =
            "https://the-internet.herokuapp.com/challenging_dom";

    private final SelenideElement pageHeader =
            $x("//h3");

    private final ChallengingDomTableLesson04Component table = new ChallengingDomTableLesson04Component(
            $(".large-10.columns"));

    @Override
    protected String getUrl() {
        return URL;
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return pageHeader;
    }

//    public ChallengingDomTableLesson04Component getTable() {
//        return table
//    }
}
