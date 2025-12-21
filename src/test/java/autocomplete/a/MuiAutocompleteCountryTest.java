package autocomplete.a;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MuiAutocompleteCountryTest {

    @Test
    void shouldSelectPoland() {
        MuiAutocompleteDocsPage page = new MuiAutocompleteDocsPage();

        page.countrySelect()
                .selectByTyping("Pol", "Poland");

        assertThat(page.countrySelect().getSingleValue())
                .isEqualTo("Poland");
    }
}