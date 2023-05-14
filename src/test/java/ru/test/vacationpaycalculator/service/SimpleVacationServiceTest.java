package ru.test.vacationpaycalculator.service;

import org.junit.jupiter.api.Test;
import ru.test.vacationpaycalculator.domain.Vacation;
import ru.test.vacationpaycalculator.repository.MemoryDateRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withinPercentage;

class SimpleVacationServiceTest {
    SimpleVacationService vacationService = new SimpleVacationService(new MemoryDateRepository());

    @Test
    void whenCount() {
        var vacation = new Vacation();
        vacation.setStartDate("2023-01-09");
        vacation.setEndDate("2023-01-10");
        vacation.setMediumSalary(336544);
        double rsl = vacationService.calculate(vacation);
        assertThat(rsl).isCloseTo(1914.35D, withinPercentage(1));
    }

}