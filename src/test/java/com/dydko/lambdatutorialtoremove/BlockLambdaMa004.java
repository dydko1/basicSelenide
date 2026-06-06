package com.dydko.lambdatutorialtoremove;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockLambdaMa004 {
    public void run() {

        List<User> users = List.of(
                new User("Mirek", 32),
                new User("Anna", 25)
        );

        List<Map<String, Integer>> maps = users.stream()
                .map(u -> {
                    Map<String, Integer> map = new HashMap<>();
                    map.put(u.name(), u.age());
                    return map;
                })
                .toList();
        System.out.println(maps);
    }
}
