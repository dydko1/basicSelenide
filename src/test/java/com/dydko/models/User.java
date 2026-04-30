package com.dydko.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class User {

    private final String name;
    private final String position;
    private final String office;
    private final String startDate;
}
