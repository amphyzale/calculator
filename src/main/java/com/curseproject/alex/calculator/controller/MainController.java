package com.curseproject.alex.calculator.controller;

import com.curseproject.alex.calculator.model.Info;
import com.curseproject.alex.calculator.model.Response;
import com.curseproject.alex.calculator.service.Calculator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculator/api/v1")
public class MainController {

    private final Calculator calculator;

    @PostMapping("/calculate")
    public Response calculate(@RequestBody List<Info> request) {
        return calculator.calculate(request);
    }
}
