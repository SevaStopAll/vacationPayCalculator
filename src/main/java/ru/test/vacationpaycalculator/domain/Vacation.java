package ru.test.vacationpaycalculator.domain;

import lombok.Data;

@Data
public class Vacation {
    private String startDate;
    private String endDate;
    private double mediumSalary;
}
