package pagination.a;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.IntStream;

public class PrimeNgTableComponent {

    private final SelenideElement tableRoot;

    public PrimeNgTableComponent(SelenideElement tableRoot) {
        this.tableRoot = tableRoot;
    }

    public List<String> getColumnTexts(String headerText) {
        Integer colIndex = findColumnIndex(headerText);
        return rows().stream()
                .map(r -> r.$$("td").get(colIndex)
                        .getText()).toList();
    }

    public Integer getRowCount() {
        return rows()
                .size();
    }

    private ElementsCollection rows() {
        return tableRoot
                .$$(":scope tbody tr");
    }

    private Integer findColumnIndex(String headerText) {
        return IntStream.range(0, tableRoot.$$(":scope thead th").size())
                .filter(i -> tableRoot.$$(":scope thead th")
                        .get(i).getText().contains(headerText))
                .findFirst()
                .orElseThrow();
    }
}