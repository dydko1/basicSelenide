package pagination.a;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;

public class PrimeNgPaginator {

    private final SelenideElement root;

    public PrimeNgPaginator(SelenideElement root) {
        this.root = root;
    }

    public void next() {
        root.$(".p-paginator-next")
                .shouldBe(enabled).click();
    }

    public Boolean hasNext() {
        return root.$(".p-paginator-next").isEnabled();
    }
}
