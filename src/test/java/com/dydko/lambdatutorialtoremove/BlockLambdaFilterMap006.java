package com.dydko.lambdatutorialtoremove;

import java.util.List;

public class BlockLambdaFilterMap006 {

    public void run() {
        List<User> users = List.of(
                new User("Mirek", 32),
                new User("Anna", 25),
                new User("Jan", 17)
        );

        List<String> result = users.stream()
                .filter(u -> u.age() >= 18)
                .map(u -> {
                    return
                            u.name().toUpperCase();
                })
                .toList();
        System.out.println(result);

    }
}
