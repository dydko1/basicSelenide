package selects.b.test;

import org.testng.annotations.Test;
import selects.b.page.MuiBasicSelectPage;

import static org.assertj.core.api.Assertions.assertThat;

public class MuiBasicSelectTest {

    @Test
    public void shouldSelectAgeTwenty() {
        MuiBasicSelectPage muiBasicSelectPage = new MuiBasicSelectPage();
        muiBasicSelectPage.openPage();
        muiBasicSelectPage.selectAgeByText("Twenty");
        assertThat(muiBasicSelectPage.getSelectedAgeText())
                .isEqualTo("Twenty");
    }
}
