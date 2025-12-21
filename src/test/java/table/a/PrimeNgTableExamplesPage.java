package table.a;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class PrimeNgTableExamplesPage {

    private final PrimeNgTableComponent basicTable;

    public PrimeNgTableExamplesPage() {
        open("https://primeng.org/table#examples");

        // pierwszy komponent <p-table> na stronie = Basic
        SelenideElement basicRoot = $$("p-table")
                .first()
                .should(appear);   // Selenide poczeka aż się wyrenderuje

        this.basicTable = new PrimeNgTableComponent(basicRoot);
    }

    public PrimeNgTableComponent basicTable() {
        return basicTable;
    }
}