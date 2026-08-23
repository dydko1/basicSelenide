package com.dydko.models;

public record Employee(
        String name,
        String position,
        String office,
        int age
) {
}