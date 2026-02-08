package com.dydko.lessons011x.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class WikipediaTabs {

    private static final String TOP_TABS_TEMPLATE = "//div[@id='p-associated-pages']//a[normalize-space()='%s']";
    private static final String TOOLS_TABS_TEMPLATE = "//div[@id='p-views']//a[normalize-space()='%s']";

    public <T> T selectTabTop(String label, Class<T> clazz) {
        getSection(label, TOP_TABS_TEMPLATE).click();
        return page(clazz);
    }

    public <T> T selectTool(String label, Class<T> clazz) {
        getSection(label, TOOLS_TABS_TEMPLATE).click();
        return page(clazz);
    }

    private SelenideElement getSection(String label, String template) {
        String normalizedLabel = label == null ? "" : label.trim();
        return $x(template
                .formatted(normalizedLabel))
                .shouldBe(interactable);
    }
}
