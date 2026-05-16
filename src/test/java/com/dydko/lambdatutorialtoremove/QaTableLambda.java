package com.dydko.lambdatutorialtoremove;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QaTableLambda {

    public void run6() {

        List<String> headers = List.of(
                "name",
                "age",
                "country"
        );

        List<List<String>> rows = List.of(
                List.of("Mirek", "32", "PL"),
                List.of("Anna", "25", "DE"),
                List.of("Jan", "17", "UK")
        );

        List<Map<String, String>> result = rows.stream()
                .map(row -> {
                    Map<String, String> map = new HashMap<>();

                    for (int i = 0; i < headers.size(); i++) {
                        String value =
                                i < row.size() ? row.get(i)
                                        : "";
                        map.put(headers.get(i), value);
                    }
                    return map;
                })
                .toList();
        result.forEach(System.out::println);
    }
}