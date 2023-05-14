package ru.test.vacationpaycalculator.service;

import ru.test.vacationpaycalculator.domain.Vacation;

public interface VacationService {
    double calculate(Vacation vacation);
}
