package com.dydko.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

@Value
public class User {
     String name;
     String position;
     String office;
     String startDate;
}
