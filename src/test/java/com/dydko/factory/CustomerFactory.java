package com.dydko.factory;

import com.dydko.model.Address;
import com.dydko.model.Customer;
import com.google.gson.Gson;

import java.util.Map;

public class CustomerFactory {

    public static String build(Map<String, String> data) {

        Address address = new Address(
                data.get("city"),
                data.get("street"),
                data.get("zipCode")
        );

        Customer customer = new Customer(
                data.get("firstName"),
                data.get("surname"),
                data.get("pesel"),
                address
        );

        return new Gson().toJson(customer);
    }
}
