package table.a;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeNgBasicTableTest {

    @Test
    void shouldReadCategoryForGivenProduct() {
        PrimeNgTableExamplesPage page = new PrimeNgTableExamplesPage();

        // szukamy wiersza po kolumnie "Name"
        SelenideElement row = page.basicTable()
                .getRowByTextInColumn("Name", "Bamboo Watch");

        // odczyt z kolumny "Category"
        String category = page.basicTable()
                .getCellText(row, "Category");

        assertThat(category).isEqualTo("Accessories");
    }
}
