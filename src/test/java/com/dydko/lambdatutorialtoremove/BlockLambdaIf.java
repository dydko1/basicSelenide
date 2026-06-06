package com.dydko.lambdatutorialtoremove;

import java.util.List;

public class BlockLambdaIf {

    public void run002() {
        List<String> names = List.of(
                "mirek",
                "",
                "anna"
        );

        List<String> result = names.stream()
                .map(n -> {
                    if (n.isBlank())
                        return n;
                    return n.toUpperCase();
                })
                .toList();
    }
}
