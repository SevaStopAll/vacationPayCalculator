package ru.test.vacationpaycalculator.repository;

import java.time.LocalDate;
import java.util.List;

public interface DateRepository {
    List<LocalDate> getHolidays();
}
