package com.dydko.lessonsgenericpowerful.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class WikipediaTabs {

    private static final String TOP_TABS_TEMPLATE = "//div[@id='p-associated-pages']//a[normalize-space()='%s']";
    private static final String TOOLS_TABS_TEMPLATE = "//div[@id='p-views']//a[normalize-space()='%s']";

    public <T> T selectTabTop(String label, Class<T> clazz) {
        return clickAndPage(label, TOP_TABS_TEMPLATE, clazz);
    }

    public <T> T selectTool(String label, Class<T> clazz) {
        return clickAndPage(label, TOOLS_TABS_TEMPLATE, clazz);
    }

    private <T> T clickAndPage(String label, String template, Class<T> clazz) {
        section(label, template).click();
        return page(clazz);
    }

    private SelenideElement section(String label, String template) {
        String normalizedLabel = label == null ? "" : label.trim();
        return $x(template
                .formatted(normalizedLabel))
                .shouldBe(interactable);
    }
}
