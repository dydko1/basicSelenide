import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Test12 {

    @Test
    public void searchBaeldung() throws Exception {
        //open("https://duckduckgo.com/");
        open("/");
        SelenideElement searchbox = $(By.id("searchbox_input"));
        searchbox.click();
        searchbox.setValue("Baeldung");
        searchbox.pressEnter();

        SelenideElement firstResult = $(By.id("r1-0"));
        firstResult.shouldHave(text("Baeldung"));

        System.out.println("ByBy");
    }
}
