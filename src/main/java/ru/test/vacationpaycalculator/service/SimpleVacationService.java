package ru.test.vacationpaycalculator.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.vacationpaycalculator.domain.Vacation;
import ru.test.vacationpaycalculator.repository.MemoryDateRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SimpleVacationService implements ru.test.vacationpaycalculator.service.VacationService {
    MemoryDateRepository holidaysDates;
    /**  * Метод принимает из POST запроса объект Vacation.
     * Далее определяется начало и конец отпуска,
     * идет проверка, не выпадает ли отпускной день на праздник, т.к.
     * в этом случае день не оплачивается работодателем, а затем происходит
     * расчет среднего дневного заработка и расчет отпускных
     * @param vacation отпуск, по которому надо рассчитать отпускные
     * @return сумма отпускных за конкретный период, указанный в запросе */
    @Override
    public double calculate(Vacation vacation) {
        LocalDate start = LocalDate.parse(vacation.getStartDate());
        LocalDate end = LocalDate.parse(vacation.getEndDate());
        List<LocalDate> dates = new ArrayList<>();
        while (!start.isAfter(end)) {
            dates.add(start);
            start = start.plusDays(1);
        }
        List<LocalDate> holidays = holidaysDates.getHolidays();
        int dayForPay = dates.size();
        for (LocalDate day : dates) {
            if (holidays.contains(day)) {
                dayForPay--;
            }
        }
        return (dayForPay * (vacation.getMediumSalary() / 12 / 29.3));
    }
}
