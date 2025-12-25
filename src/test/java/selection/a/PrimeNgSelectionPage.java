package selection.a;

import static com.codeborne.selenide.Selenide.*;

public class PrimeNgSelectionPage {

    private PrimeNgSelectionTable table;

    public PrimeNgSelectionPage openPrimeNg() {
        open("https://primeng.org/table#selection");

        table = new PrimeNgSelectionTable();
        table.shouldBeVisible();
        return this;
    }

    public PrimeNgSelectionTable table() {
        return table;
    }
}
