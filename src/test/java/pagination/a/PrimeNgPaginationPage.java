package pagination.a;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PrimeNgPaginationPage {

    private PrimeNgTableComponent table;
    private PrimeNgPaginator paginator;

    public void openPrimeNg() {
        open("https://primeng.org/table#examples");

        table = new PrimeNgTableComponent();
        paginator = new PrimeNgPaginator(table.root());
    }

    public PrimeNgTableComponent table() {
        return table;
    }

    public PrimeNgPaginator paginator() {
        return paginator;
    }
}