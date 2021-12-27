package com.curseproject.alex.calculator.service.impl;

import com.curseproject.alex.calculator.model.Info;
import com.curseproject.alex.calculator.service.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class CalculatorImpl implements Calculator {
    @Override
    public Map<String, String> calculate(Info info) {
        return null;
    }
}
