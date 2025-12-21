package autocomplete.a;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MuiAutocompleteComponent {
    private final SelenideElement root;
    private final SelenideElement input;
    private final SelenideElement label;

    public MuiAutocompleteComponent(SelenideElement root) {
        this.root = root;
        this.input = root.$("input");   // tekstowe pole MUI
        this.label = root.$("label");   // np. "Movie", "Choose a country"
    }

    public void selectByTyping(String search, String optionText) {
        input.should(appear).click();
        input.setValue(search);

        options()
                .findBy(text(optionText))
                .should(appear, Duration.ofSeconds(10))
                .click();
    }

    public String getSingleValue() {
        return input.shouldBe(visible).getValue();
    }

    public void assertChipSelected(String chipText) {
        chips().findBy(text(chipText)).should(appear);
    }

    private ElementsCollection options() {
        return $$("[role='option']");
    }

    private ElementsCollection chips() {
        // wybrane wartości w multi-autocomplete
        return $$("div.MuiChip-root");
    }

    public String getLabelText() {
        return label.shouldBe(visible).getText();
    }
}
