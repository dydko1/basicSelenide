package com.dydko.lesson008.tests;

import com.dydko.lesson008.pages.AddRemoveElements008Page;
import com.dydko.lesson008.pages.DynamicControls008Page;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;

class DynamicControls008Test {

    @Test
    void shouldEnableInput() {
        DynamicControls008Page page = new DynamicControls008Page();
        page.openPage();
        page.getToggleInputButton()
                .click();
        page.getInput()
                .shouldBe(enabled)
                .setValue("Miro");
    }

    @Test
    void shouldAddAndRemoveElements() {
        AddRemoveElements008Page page = new AddRemoveElements008Page();

        page.openPage();
        page.getAddButton().click();
        page.getAddButton().click();

        page.getDeleteButtons().shouldHave(size(2));

        page.getDeleteButtons().first().click();
        page.getDeleteButtons().shouldHave(size(1));
    }
}