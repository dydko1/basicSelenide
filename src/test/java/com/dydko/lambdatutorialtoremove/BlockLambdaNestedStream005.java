package com.dydko.lambdatutorialtoremove;

import java.util.List;

public class BlockLambdaNestedStream005 {
    public void run() {

        List<List<Integer>> numbers = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );

        List<Integer> sum = numbers.stream()
                .map(list -> {
                    return list.stream().mapToInt(s -> s)
                            .sum();
                })
                .toList();
        System.out.println(sum);
    }
}
