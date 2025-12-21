package autocomplete.a;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MuiAutocompleteDocsPage {

    private final MuiAutocompleteComponent movieCombo;
    private final MuiAutocompleteComponent countrySelect;
    private final MuiAutocompleteComponent multiMovies;

    public MuiAutocompleteDocsPage() {
        open("https://mui.com/material-ui/react-autocomplete/");

        // 1) Combo box – Movie
        this.movieCombo = new MuiAutocompleteComponent(
                $$("div.MuiAutocomplete-root")
                        .findBy(text("Movie"))
        );

        // 2) Country select – label "Choose a country"
        this.countrySelect = new MuiAutocompleteComponent(
                $$("div.MuiAutocomplete-root")
                        .findBy(text("Choose a country"))
        );

        // 3) Multiple values – sekcja "Multiple values"
        this.multiMovies = new MuiAutocompleteComponent(
                $$("div.MuiAutocomplete-root")
                        .findBy(text("Multiple values"))
        );
    }

    public MuiAutocompleteComponent movieCombo() {
        return movieCombo;
    }

    public MuiAutocompleteComponent countrySelect() {
        return countrySelect;
    }

    public MuiAutocompleteComponent multiMovies() {
        return multiMovies;
    }
}