package autocomplete.a;


import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MuiAutocompleteSingleTest {

    @Test
    void shouldSelectMovieByTyping() {
        MuiAutocompleteDocsPage page = new MuiAutocompleteDocsPage();

        page.movieCombo()
                .selectByTyping("godf", "The Godfather");

        assertThat(page.movieCombo().getSingleValue())
                .isEqualTo("The Godfather");
    }
}