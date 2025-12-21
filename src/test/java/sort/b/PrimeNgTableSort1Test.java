package sort.b;

import org.testng.annotations.Test;
import sort.a.PrimeNgTableComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeNgTableSort1Test {
    @Test
    void shouldSortByNameAscending() {
        PrimeNgTableSort1Page page = new PrimeNgTableSort1Page();
        page.openPage();

        PrimeNgTable1Component table = page.table();
        // 1. klik sort
        table.sortBy("Quantity");

        // 2. pobierz wartości z kolumny
        List<String> names = table.getColumnTexts("Quantity");

        // 3. porównaj z posortowaną kopią
        List<String> sorted = new ArrayList<>(names);
        Collections.sort(sorted);

        assertThat(names).isEqualTo(sorted);

    }
}
