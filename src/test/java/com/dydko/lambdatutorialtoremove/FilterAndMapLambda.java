package com.dydko.lambdatutorialtoremove;

import java.util.List;

public class FilterAndMapLambda {
    public void run4() {

        List<User> users = List.of(
                new User("Mirek", 32),
                new User("Anna", 25),
                new User("Jan", 17)
        );

        List<String> adults = users.stream()
                .filter(user->user.age()>=18)
                .map(user->user.name().toUpperCase())
                .toList();
        System.out.println(adults);
    }
}
