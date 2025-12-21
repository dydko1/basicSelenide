package selects.b.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MuiBasicSelectPage {

    //private final SelenideElement ageSelect = $x("//*[@id='demo-simple-select']");
    private final SelenideElement ageSelect = $("#demo-simple-select");

    public void openPage() {
        open("https://mui.com/material-ui/react-select/");
    }

    public void selectAgeByText(String visibleText) {
        ageSelect
                //.scrollTo()
                .scrollIntoCenter()
                .shouldBe(visible, enabled)
                .click();
        //$$x("//li[@role='option']")
        $$("li[role='option']")
                .findBy(text(visibleText))
                .should(appear)
                .click();
    }

    public String getSelectedAgeText() {
        return ageSelect
                .shouldBe(visible)
                .getText();
    }
}