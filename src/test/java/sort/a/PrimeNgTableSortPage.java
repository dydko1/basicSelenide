package sort.a;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.appear;

public class PrimeNgTableSortPage {

    private PrimeNgTableComponent table;

    public PrimeNgTableSortPage openPage() {
        open("https://primeng.org/table#examples");

        SelenideElement sortHeading = $$("h2, h3")
                .findBy(text("Sort"))
                .should(appear, Duration.ofSeconds(15));

        sortHeading.scrollIntoView(true);

        // bierzemy pierwszą tabelę WYSTĘPUJĄCĄ PO nagłówku "Sort"
        SelenideElement tableRoot = sortHeading
                .$x("following::p-table[1]")
                .should(appear, Duration.ofSeconds(15));

        this.table = new PrimeNgTableComponent(tableRoot);
        return this;
    }

    public PrimeNgTableComponent table() {
        return table;
    }
}