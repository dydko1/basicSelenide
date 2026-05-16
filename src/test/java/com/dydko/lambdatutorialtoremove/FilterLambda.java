package com.dydko.lambdatutorialtoremove;

import java.util.List;

public class FilterLambda {

    public void run1() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> even = numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();
        System.out.println(even);
    }
}
