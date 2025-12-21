package selects.a;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SyncfusionMultiSelectTest {
    @Test
    public void shouldSelectSeveralCountries() {
        open("https://ej2.syncfusion.com/demos/multi-select/checkbox/");

        SelenideElement multiSelect= $(".e-multiselect");
        multiSelect.click();
        selectCountry("Australia");
        selectCountry("Canada");
        selectCountry("India");

        ElementsCollection selectedOptions  =  $$("#checkbox_popup li.e-list-item.e-active");
        selectedOptions .shouldHave(texts("Australia", "Canada", "India"));
        System.out.println("dff");
    }

    private void selectCountry(String countryName) {
        // każdy kraj to <li class="e-list-item"> z tekstem, kliknięcie zaznacza checkbox
        $$(".e-popup .e-list-item")
                .findBy(text(countryName))
                .shouldBe(visible)
                .click();
    }
}
