package pagination.a;
// PrimeNgTableComponent.java

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class PrimeNgTableComponent {

    public SelenideElement root() {
        return $("div.p-datatable").shouldBe(visible);
    }

    private ElementsCollection headerCells() {
        return root().$$("thead th");
    }

    private ElementsCollection rows() {
        return root().$$("tbody tr");
    }

    public void shouldBeVisible() {
        root().shouldBe(visible);
    }

    public int getRowCount() {
        return rows().size();
    }

    public List<String> getColumnTexts(String headerName) {
        int index = headerCells().texts().indexOf(headerName);
        if (index < 0) throw new IllegalArgumentException("No column: " + headerName);

        return rows().stream()
                .map(r -> r.$$("td").get(index).getText())
                .toList();
    }
}
