package filter.a;

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

    private int findColumnIndex(String headerText) {
        return IntStream.range(0, headerCells().size())
                .filter(i -> headerCells().get(i).getText().contains(headerText))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("No header containing: " + headerText));
    }

    public void filterByText(String headerText, String value) {
        int colIndex = findColumnIndex(headerText);

        SelenideElement input = filterCells()
                .get(colIndex)
                .$("input");

        input.shouldBe(visible).clear();
        input.setValue(value);
    }

    public int getRowCount() {
        return bodyRows().size();
    }

    public List<String> getColumnTexts(String headerText) {
        int colIndex = findColumnIndex(headerText);

        return bodyRows().stream()
                .map(row -> row.findAll("td").get(colIndex).getText())
                .toList();
    }

    private ElementsCollection headerCells() {
        return root.$$(":scope thead th");
    }

    private ElementsCollection filterCells() {
        // drugi wiersz nagłówka = filtry
        return root.$$(":scope thead tr").get(1).$$("th");
    }

    private ElementsCollection bodyRows() {
        return root.$$(":scope tbody tr");
    }
}
