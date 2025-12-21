package filter.a;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.appear;

public class PrimeNgTableFilterPage {

    private PrimeNgTableComponent table;

    public PrimeNgTableFilterPage openPage() {
        open("https://primeng.org/table#examples");

        SelenideElement filterHeading = $$("h2, h3")
                .findBy(text("Filter"))
                .should(appear, Duration.ofSeconds(15));
        filterHeading.scrollTo();

        SelenideElement tableRoot = filterHeading
                .$x("following::p-table[1]")
                .should(appear, Duration.ofSeconds(15));

        this.table = new PrimeNgTableComponent(tableRoot);
        return this;
    }

    public PrimeNgTableComponent table() {
        return table;
    }
}