package com.dydko.models;

public record Employee(
        String firstName,
        String lastName,
        int age,
        String email,
        int salary,
        String department
) {
}