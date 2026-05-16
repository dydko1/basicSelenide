package com.dydko.lambdatutorialtoremove;

import java.util.List;

public class BlockLambdaBasic01 {
    public void run01() {
        System.out.println("--------------");

        List<String> names = List.of(
                "mirek",
                "anna",
                "jan"
        );

        List<String> result = names.stream()
                .map(String::toUpperCase)
                .toList();

//        List<String> result = names.stream()
//                .map(name -> {
//                    String upper =
//                            name.toUpperCase();
//                    return upper;
//                })
//                .toList();

        System.out.println(result);
    }
}
