package com.dydko.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Employee {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;
    private final int salary;
    private final String department;
}