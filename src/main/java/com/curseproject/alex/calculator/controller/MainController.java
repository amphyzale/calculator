package com.curseproject.alex.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculator/api/v1")
public class MainController {

    @GetMapping("/info")
    public String info() {
        return "info";
    }
}
