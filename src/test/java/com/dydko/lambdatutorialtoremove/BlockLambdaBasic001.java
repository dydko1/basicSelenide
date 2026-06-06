package com.dydko.lambdatutorialtoremove;

import java.util.List;

public class BlockLambdaBasic001 {

    public void run001() {
        List<String> names = List.of(
                "mirek",
                "anna",
                "jan"
        );
        List<String> result = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(result);}

}