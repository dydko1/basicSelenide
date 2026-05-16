package com.dydko.lambdatutorialtoremove;

import java.util.List;

public class BlockLambda {

    public void run3() {

        List<String> names = List.of(
                " mirek ",
                " anna ",
                " jan "
        );
        System.out.println(names);
        List<String> result = names.stream()
                .map(name -> {
                    System.out.println("Before: " + name + "X");
                    String trimmed = name.strip();
                    String upper = trimmed.toUpperCase();
                    System.out.println("After: " + upper + "X");
                    return upper;
                })
                .toList();
        System.out.println(result);
    }
}
