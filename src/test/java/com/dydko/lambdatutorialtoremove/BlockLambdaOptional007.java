package com.dydko.lambdatutorialtoremove;

import java.util.List;
import java.util.Optional;

public class BlockLambdaOptional007 {

    public void run() {
        List<Optional<String>> names = List.of(
                Optional.of("MIREK"),
                Optional.of(""),
                Optional.of("   "),
                Optional.empty(),
                Optional.of("ANNA")
        );

        List<String> result = names.stream()
                .map(n -> {
//                            Optional<String> optional =
//                                    Optional.ofNullable(n);

                            if (n.isEmpty())
                                return "NULL";
                            String value = n.get().strip();
                            if (value.isBlank())
                                return "EMPTY";
                            return value.toUpperCase();
                        }
                ).toList();
        System.out.println(result);
    }
}
