// PrimeNgPaginator.java (hasNext + reszta)
package pagination.a;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.cssClass;

public class PrimeNgPaginator {

    private final SelenideElement tableRoot;

    public PrimeNgPaginator(SelenideElement tableRoot) {
        this.tableRoot = tableRoot;
    }

    private SelenideElement root() {
        // paginator jest obok tabeli (w tym samym wrapperze)
        return tableRoot.parent().$(".p-paginator").shouldBe(visible);
    }

    private SelenideElement nextBtn() {
        return root().$(".p-paginator-next").shouldBe(visible);
    }

    public boolean hasNext() {
        // PrimeNG używa p-disabled na przycisku, a czasem też aria-disabled
        if (nextBtn().has(cssClass("p-disabled"))) return false;

        String aria = nextBtn().getAttribute("aria-disabled");
        return !"true".equals(aria);
    }

    public void next() {
        nextBtn().shouldBe(enabled).click();
    }

    public void first() {
        root().$(".p-paginator-first").shouldBe(enabled).click();
    }

    public void goToPage(int pageNumber) {
        root().$$(".p-paginator-page")
                .findBy(text(String.valueOf(pageNumber)))
                .shouldBe(visible)
                .click();
    }
}
