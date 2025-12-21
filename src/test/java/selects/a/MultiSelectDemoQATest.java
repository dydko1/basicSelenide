package selects.a;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;

public class MultiSelectDemoQATest {

    @Test
    public void selectMultipleCars() {
        // nie korzystamy z baseUrl – wchodzimy bezpośrednio
        open("https://demoqa.com/select-menu");

        SelenideElement multiSelect = $(id("cars"));

        // wybór kilku opcji naraz (po widocznym tekście)
        multiSelect.selectOption("Volvo", "Saab", "Audi");

        // asercja – sprawdzamy, że dokładnie te opcje są zaznaczone
        multiSelect.getSelectedOptions()
                   .shouldHave(exactTexts("Volvo", "Saab", "Audi"));
    }
}