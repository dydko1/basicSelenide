package com.dydko.lambdatutorialtoremove;

import java.util.List;

public class MapLambda {
    public void run2() {
        List<String> names = List.of(
                "mirek",
                "anna",
                "jan"
        );

        List<String> upper = names.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(upper);
    }
}
