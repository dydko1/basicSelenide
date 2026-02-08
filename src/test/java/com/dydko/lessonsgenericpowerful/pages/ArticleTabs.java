package com.dydko.lessonsgenericpowerful.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.Objects;
import java.util.function.Consumer;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ArticleTabs {

    private static final String TOP_TABS_TEMPLATE = "//div[@id='p-associated-pages']//a[normalize-space()='%s']";
    private static final String TOOLS_TABS_TEMPLATE = "//div[@id='p-views']//a[normalize-space()='%s']";

    public <T> T selectTabTop(String label, Class<T> clazz, Consumer<T> shouldBeLoaded) {
        Objects.requireNonNull(shouldBeLoaded, "shouldBeLoaded must not be null");
        click(label, TOP_TABS_TEMPLATE);
        T p = page(clazz);
        shouldBeLoaded.accept(p);
        return p;
    }

    public <T> T selectTool(String label, Class<T> clazz, Consumer<T> shouldBeLoaded) {
        Objects.requireNonNull(shouldBeLoaded, "shouldBeLoaded must not be null");
        click(label, TOOLS_TABS_TEMPLATE);
        T p = page(clazz);
        shouldBeLoaded.accept(p);
        return p;
    }

    private void click(String label, String template) {
        section(label, template).shouldBe(interactable).click();
    }

    private SelenideElement section(String label, String template) {
        String normalized = label == null ? "" : label.trim();
        return $x(template.formatted(normalized));
    }
}
