package com.curseproject.alex.calculator.service;

import com.curseproject.alex.calculator.model.Info;
import com.curseproject.alex.calculator.model.Response;

import java.util.List;

public interface Calculator {
    Response calculate(List<Info> infos);
}
