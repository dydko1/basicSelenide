package selection.a;
import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PrimeNgSelectionTable {

    private SelenideElement root() {
        return $$("div.p-datatable")
                .findBy(visible)
                .shouldBe(visible);
    }

    private ElementsCollection rows() {
        return root().$$("tbody tr");
    }

    public void shouldBeVisible() {
        rows().first().shouldBe(visible);
    }

    public void selectRow(int index) {
        rows().get(index)
                .$("[role='radio'], [role='checkbox']")
                .click();
    }

    public boolean isRowSelected(int index) {
        return "true".equals(
                rows().get(index)
                        .$("[role='radio'], [role='checkbox']")
                        .getAttribute("aria-checked")
        );
    }
}