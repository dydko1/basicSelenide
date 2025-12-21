package sort.b;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PrimeNgTableSort1Page {

    private PrimeNgTable1Component table;

    public void openPage() {
        open("https://primeng.org/table#examples");

        SelenideElement sortHeading = $$("h2, h3")
                .findBy(text("Sort"))
                .should(appear, Duration.ofSeconds(15));
        sortHeading.scrollTo();

        SelenideElement tableRoot = sortHeading
                .$x("following::p-table[1]")
                .should(appear, Duration.ofSeconds(15));

        this.table = new PrimeNgTable1Component(tableRoot);
    }

    public PrimeNgTable1Component table() {
        return table;
    }
}
