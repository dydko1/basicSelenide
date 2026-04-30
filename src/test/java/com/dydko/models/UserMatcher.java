package com.dydko.models;


public class UserMatcher {

    public static boolean matches(User expected, User actual) {

        return (isEmpty(expected.getName()) ||
                expected.getName().equals(actual.getName()))
                && (isEmpty(expected.getPosition()) ||
                expected.getPosition().equals(actual.getPosition()))
                && (isEmpty(expected.getOffice()) ||
                expected.getOffice().equals(actual.getOffice()))
                && (isEmpty(expected.getStartDate()) ||
                expected.getStartDate().equals(actual.getStartDate()));
    }

    private static boolean isEmpty(String v) {
        return v == null || v.isBlank();
    }
}