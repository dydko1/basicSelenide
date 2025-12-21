package table.a;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.NoSuchElementException;

public class PrimeNgTableComponent {

    private final SelenideElement root;

    public PrimeNgTableComponent(SelenideElement root) {
        this.root = root;
    }

    private ElementsCollection headerCells() {
        return root.$$("thead th");
    }

    private ElementsCollection bodyRows() {
        return root.$$("tbody tr");
    }

    /**
     * Szuka wiersza, gdzie w kolumnie o nagłówku headerText
     * jest dokładnie cellText.
     */
    public SelenideElement getRowByTextInColumn(String headerText, String cellText) {
        int colIndex = headerCells()
                .texts()
                .indexOf(headerText);

        if (colIndex == -1) {
            throw new IllegalArgumentException("No header with text: " + headerText);
        }

        return bodyRows()
                .stream()
                .filter(row -> row.findAll("td").get(colIndex).getText().equals(cellText))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "No row with '" + cellText + "' in column '" + headerText + "'"
                ));
    }

    /**
     * Zwraca tekst z komórki w danym wierszu i kolumnie (po nagłówku).
     */
    public String getCellText(SelenideElement row, String headerText) {
        int colIndex = headerCells()
                .texts()
                .indexOf(headerText);

        if (colIndex == -1) {
            throw new IllegalArgumentException("No header with text: " + headerText);
        }

        return row.findAll("td").get(colIndex).getText();
    }
}
