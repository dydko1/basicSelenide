package filter.a;


import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeNgTableFilterTest {

    @Test
    void shouldFilterByName() {
        PrimeNgTableFilterPage page = new PrimeNgTableFilterPage()
                .openPage();

        PrimeNgTableComponent table = page.table();

        table.filterByText("Name", "Donette Foller");

        assertThat(table.getRowCount()).isGreaterThan(0);
        assertThat(table.getColumnTexts("Name"))
                .allMatch(text -> text.contains("Donette Foller"));
    }
}
