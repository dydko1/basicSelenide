package selects.a;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

public class DatePickerTest {
    @Test
    public void shouldSelectSeveralCountries() {
        open("https://demoqa.com/date-picker");
//        SelenideElement input = $("#datePickerMonthYearInput");
//        input.click();
//        //$(".react-datepicker__day--015:not(.react-datepicker__day--outside-month)").click();
//        while (!$(".react-datepicker__current-month").text().equals("April 2030")) {
//            $(".react-datepicker__navigation--next").click();
//        }
//        System.out.println();

        SelenideElement input = $("#datePickerMonthYearInput");
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        input.sendKeys(setDate(LocalDate.parse("2018-11-25")));
        input.pressEnter();

        //input.shouldHave(value(setDate(LocalDate.parse("2018-11-01"))));
        System.out.println("ddd");
    }

    private String setDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
        return formatter.format(date);
    }
}
