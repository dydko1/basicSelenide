package com.dydko.data;

//import lombok.Getter;
//import lombok.RequiredArgsConstructor;

import java.util.Map;

//@RequiredArgsConstructor
//@Getter
public record TableData(String keyColumn, Map<String, Map<String, String>> rows) {

}