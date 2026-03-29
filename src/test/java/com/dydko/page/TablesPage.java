package com.dydko.page;

import com.codeborne.selenide.SelenideElement;
import com.dydko.data.TableData;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Slf4j
public class TablesPage {

    private final SelenideElement table = $("#table1");

    public void openUrl(String url) {
        open(url);
    }


    public TableData getTable() {

        List<String> headers = table
                .shouldBe(visible)
                .$$("thead th")
                .shouldHave(sizeGreaterThan(0))
                .texts();

        String keyColumn = headers.get(0);

        log.debug("Headers: {}", headers);
        log.debug("Key column: {}", keyColumn);

        Map<String, Map<String, String>> rows = table.$$("tbody tr").stream()
                .map(row -> row.$$("td").texts())
                .map(cells ->
                        IntStream.range(0, headers.size())
                                .boxed()
                                .collect(Collectors.toMap(
                                        headers::get,
                                        i -> i < cells.size() ? cells.get(i) : ""
                                ))
                )
                .collect(Collectors.toMap(
                        row -> row.get(keyColumn),
                        row -> row,
                        (a, b) -> {
                            throw new RuntimeException("Duplicate key: " + a);
                        }
                ));

        log.debug("Parsed rows: {}", rows);

        return new TableData(keyColumn, rows);
    }
}
