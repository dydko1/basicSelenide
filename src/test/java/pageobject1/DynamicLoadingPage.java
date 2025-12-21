package pageobject1;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class DynamicLoadingPage {

    private SelenideElement startButton = $("#start button");
    private SelenideElement loading = $("#loading");
    private SelenideElement finish = $("#finish");

    public void openExample1() {
        open("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    public void openExample2() {
        open("https://the-internet.herokuapp.com/dynamic_loading/2");
    }

    public void clickStartAndWaitForHelloWorld() {
        startButton.click();
        loading.should(appear);
        loading.should(disappear, Duration.ofSeconds(10));
        finish.should(appear)
                .shouldHave(text("Hello World!"));

    }

    public boolean isFinishInDomNow() {
        // Selenide: istnieje w DOM, ale może być niewidoczny
        return finish.exists();
    }

    public boolean isFinishVisibleNow() {
        return finish.is(visible);
    }
}