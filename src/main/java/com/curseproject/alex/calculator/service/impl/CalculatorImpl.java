package com.curseproject.alex.calculator.service.impl;

import com.curseproject.alex.calculator.model.Info;
import com.curseproject.alex.calculator.model.Response;
import com.curseproject.alex.calculator.model.Task;
import com.curseproject.alex.calculator.service.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CalculatorImpl implements Calculator {

    private static final String TIME_TEMPLATE = "%2.2fh";

    @Override
    public Response calculate(List<Info> infos) {
        final List<Task> taskList = infos.stream()
                .map(i -> {
                    final Double environmentalFactors = getEnvironmentalFactors(i);
                    final Double priority = resolvePriority(i.getTestPriority());
                    final double pertValue = (i.getOptimisticGrade() + (4 * i.getPessimisticGrade() * environmentalFactors) +  i.getPessimisticGrade()) / 6;
                    final double ucpValue = i.getCaseCount() * i.getTimeForOneCase() * i.getComplexityCoefficient() * environmentalFactors;
                    final double fpValue = i.getCheckListTestCount() * priority * i.getTimeForOneTest();
                    return new Task()
                            .setTaskNumber(i.getTaskNumber())
                            .setPertValue(String.format(TIME_TEMPLATE, Math.floor(pertValue * 4) / 4))
                            .setUcpValue(String.format(TIME_TEMPLATE, Math.floor(ucpValue * 4) / 4))
                            .setFpValue(String.format(TIME_TEMPLATE, Math.floor(fpValue * 4) / 4))
                            .setSummaryValue(String.format(TIME_TEMPLATE, Math.floor((ucpValue + fpValue) * 4) / 4));
                })
                .collect(Collectors.toList());
        final Response response = new Response();
        response.setTasks(taskList);
        return response;
    }


    private Double getEnvironmentalFactors(Info info) {
        return resolveFactor(info.getIsStandAvailable()) +
                resolveFactor(info.getIsBackDone()) +
                resolveFactor(info.getIsFrontDone()) +
                resolveFactor(info.getIsAllTestersWorkFullDay()) +
                resolveFactor(info.getHasAutotests());
    }

    private Double resolveFactor(boolean param) {
        return Boolean.TRUE == param ? 0.2 : 0;
    }

    private Double resolvePriority(List<String> testPriority) {
        double result = 0;
        if (testPriority.contains("critical")) {
            result += 2;
        }
        if (testPriority.contains("medium")) {
            result += 1;
        }
        if (testPriority.contains("low")) {
            result += 0.5;
        }
        return result / testPriority.size();
    }

}
