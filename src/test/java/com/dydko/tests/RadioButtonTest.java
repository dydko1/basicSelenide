package com.dydko.tests;

import com.dydko.pages.RadioButtonPage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RadioButtonTest {

    private final RadioButtonPage page =
            new RadioButtonPage();

    @Test
    void shouldDisplayAvailableOptions() {
        page.open();
        List<String> options =
                page.radioButtons()
                        .getOptions();
        assertThat(options)
                .containsExactly(
                        "Yes",
                        "Impressive",
                        "No"
                );
    }

    @Test
    void shouldSelectYes() {
        page.open();
        page.radioButtons()
                .select("Yes")
                .shouldBeSelected("Yes");
        assertThat(
                page.radioButtons()
                        .isSelected("Yes")
        ).isTrue();
    }

    @Test
    void shouldSelectImpressive() {
        page.open();
        page.radioButtons()
                .select("Impressive")
                .shouldBeSelected("Impressive");
        assertThat(
                page.radioButtons()
                        .isSelected("Impressive")
        ).isTrue();
    }
}