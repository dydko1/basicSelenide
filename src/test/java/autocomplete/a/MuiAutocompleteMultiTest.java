package autocomplete.a;

import org.testng.annotations.Test;

public class MuiAutocompleteMultiTest {

    @Test
    void shouldAddMovieChip() {
        MuiAutocompleteDocsPage page = new MuiAutocompleteDocsPage();

        page.multiMovies()
                .selectByTyping("pulp", "Pulp Fiction");

        page.multiMovies().assertChipSelected("Pulp Fiction");
        page.multiMovies().assertChipSelected("Inception"); // jeśli jest domyślnie
    }
}