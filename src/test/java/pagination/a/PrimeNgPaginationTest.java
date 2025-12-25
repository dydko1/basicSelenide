package pagination.a;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeNgPaginationTest {
    @Test
    void shouldChangeDataAfterNextPage() {
        PrimeNgPaginationPage page = new PrimeNgPaginationPage();
        page.openPrimeNg();

        List<String> firstPage = page.table().getColumnTexts("Name");

        page.paginator().next();

        List<String> secondPage = page.table().getColumnTexts("Name");

        assertThat(secondPage).isNotEqualTo(firstPage);
    }

    @Test
    void shouldFindRecordAcrossPages() {
        PrimeNgPaginationPage page = new PrimeNgPaginationPage();
        page.openPrimeNg();

        String wanted = "James Butt";
        boolean found = false;

        page.paginator().first();

        do {
            found = page.table().getColumnTexts("Name")
                    .contains(wanted);

            if (found) break;

            if (!page.paginator().hasNext()) break;
            page.paginator().next();

        } while (true);

        assertThat(found).isTrue();
    }

    @Test
    void shouldGoToNextPageAndDataShouldChange() {
        PrimeNgPaginationPage page = new PrimeNgPaginationPage();
        page.openPrimeNg();

        List<String> firstPage =
                page.table().getColumnTexts("Name");

        page.paginator().next();

        List<String> secondPage =
                page.table().getColumnTexts("Name");

        assertThat(secondPage).isNotEqualTo(firstPage);
        assertThat(page.table().getRowCount()).isGreaterThan(0);
    }


}
