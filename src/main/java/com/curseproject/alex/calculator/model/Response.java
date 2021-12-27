package com.curseproject.alex.calculator.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class Response implements Serializable {

    private List<Task> tasks;

}
