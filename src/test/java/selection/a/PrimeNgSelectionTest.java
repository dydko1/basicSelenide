package selection.a;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeNgSelectionTest {

    @Test
    public void shouldSelectSingleRow() {
        PrimeNgSelectionPage page = new PrimeNgSelectionPage()
                .openPrimeNg();

        page.table().selectRow(0);

        assertThat(page.table().isRowSelected(0)).isTrue();
    }
}
