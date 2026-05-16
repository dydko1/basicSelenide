package com.dydko.lambdatutorialtoremove;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsToMapLambda {

    public void run5() {

        List<User> users = List.of(
                new User("Mirek", 32),
                new User("Anna", 25),
                new User("Jan", 17)
        );

        Map<String, Integer> result = users.stream()

                .collect(Collectors.toMap(
                        User::name,
                        User::age
                ));

        System.out.println(result);
//        List<User> users = List.of(
//                new User("Mirek", 32),
//                new User("Anna", 25),
//                new User("Jan", 17),
//                new User("Jan2", 170)
//        );
//
//        System.out.println(users.size());
//        List<Map<String, Integer>> result = users.stream()
//                .map(u -> Map.of(u.name(), u.age()))
//                .toList();
//        System.out.println(result);
    }
}
