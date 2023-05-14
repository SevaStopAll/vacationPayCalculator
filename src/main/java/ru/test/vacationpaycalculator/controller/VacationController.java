package ru.test.vacationpaycalculator.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.vacationpaycalculator.domain.Vacation;
import ru.test.vacationpaycalculator.service.VacationService;


@RestController
@AllArgsConstructor
@RequestMapping("/calculate")
public class VacationController {
    private VacationService vacationService;

    @PostMapping("/")
    public ResponseEntity<String> count(@RequestBody Vacation vacation) {
        double vacationPay = vacationService.calculate(vacation);
        String body = String.format("%.2f", vacationPay);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.TEXT_PLAIN)
                .body(body);
    }

}
