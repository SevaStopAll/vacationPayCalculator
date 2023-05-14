package ru.test.vacationpaycalculator.repository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MemoryDateRepository implements ru.test.vacationpaycalculator.repository.DateRepository {
    List<LocalDate> holidays = List.of(LocalDate.parse("2023-01-01"),
            LocalDate.parse("2023-01-02"),
            LocalDate.parse("2023-01-03"),
            LocalDate.parse("2023-01-04"),
            LocalDate.parse("2023-01-05"),
            LocalDate.parse("2023-01-06"),
            LocalDate.parse("2023-01-07"),
            LocalDate.parse("2023-01-08"),
            LocalDate.parse("2023-02-23"),
            LocalDate.parse("2023-03-08"),
            LocalDate.parse("2023-05-01"),
            LocalDate.parse("2023-05-09"),
            LocalDate.parse("2023-06-12"),
            LocalDate.parse("2023-12-31"));

    @Override
    public List<LocalDate> getHolidays() {
        return holidays;
    }
}
