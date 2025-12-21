package sort.a;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Condition.visible;

public class PrimeNgTableComponent {

    private final SelenideElement root;

    public PrimeNgTableComponent(SelenideElement root) {
        this.root = root;
    }

    private ElementsCollection headerCells() {
        return root.$$(":scope thead th");
    }

    private ElementsCollection bodyRows() {
        return root.$$(":scope tbody tr");
    }

    private int findColumnIndex(String headerText) {
        return IntStream.range(0, headerCells().size())
                .filter(i -> headerCells().get(i).getText().contains(headerText))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("No header containing: " + headerText));
    }

    /* ================= SORT ================= */

    public void sortBy(String headerText) {
        int colIndex = findColumnIndex(headerText);
        headerCells().get(colIndex).click();
    }

    public List<String> getColumnTexts(String headerText) {
        int colIndex = findColumnIndex(headerText);

        return bodyRows().stream()
                .map(row -> row.findAll("td").get(colIndex).getText())
                .toList();
    }

    public void shouldBeVisible() {
        root.shouldBe(visible);
    }
}