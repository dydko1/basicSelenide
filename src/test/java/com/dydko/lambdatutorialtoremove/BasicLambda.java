package com.dydko.lambdatutorialtoremove;

import java.util.List;

public class BasicLambda {
    public void run() {
        List<String> names = List.of("Mirek", "Anna", "Jan");
        names.forEach(System.out::println);

    }
}
