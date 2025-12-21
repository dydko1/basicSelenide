package sort.a;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeNgTableSortTest {

    @Test
    void shouldSortByNameAscending() {
        PrimeNgTableSortPage page = new PrimeNgTableSortPage()
                .openPage();

        PrimeNgTableComponent table = page.table();

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