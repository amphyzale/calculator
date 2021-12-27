package com.curseproject.alex.calculator.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
@ToString
public class Task implements Serializable {
    private String taskNumber;
    private String pertValue;
    private String ucpValue;
    private String fpValue;
    private String summaryValue;
}
