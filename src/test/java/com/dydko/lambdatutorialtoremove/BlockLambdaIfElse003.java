package com.dydko.lambdatutorialtoremove;

import java.util.List;

public class BlockLambdaIfElse003 {

    public void run003() {
        List<User> users = List.of(
                new User("Mirek", 32),
                new User("Jan", 15)
        );

        List<String> result = users.stream()
                .map(n -> {
                    if (n.age() < 18)
                        return "Child";
                    return "Adult";
                })
                .toList();
        System.out.println(result);
    }
}
