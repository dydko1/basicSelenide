package ajax;

import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class AjaxData {
    @Test
    void shouldWaitForAjaxData() {
        open("http://uitestingplayground.com/ajax");
        $("#ajaxButton")
                .click();
        $(".bg-success")
                .should(appear, Duration.ofSeconds(20))
                .shouldHave(text("Data loaded with AJAX get request."));
        System.out.println("d");
    }
}