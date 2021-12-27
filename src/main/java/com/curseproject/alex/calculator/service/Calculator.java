package com.curseproject.alex.calculator.service;

import com.curseproject.alex.calculator.model.Info;

import java.util.Map;

public interface Calculator {
    Map<String, String> calculate(Info info);
}
