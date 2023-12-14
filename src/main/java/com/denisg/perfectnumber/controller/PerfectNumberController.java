package com.denisg.perfectnumber.controller;

import com.denisg.perfectnumber.service.PerfectNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfectnumber")
public class PerfectNumberController {

    @Autowired
    PerfectNumberService perfectNumberService;

    @GetMapping
    public Boolean isPerfectNumber(
            @RequestParam(name = "myNumber") int myNumber
    ){
        return perfectNumberService.isPerfectNumber(myNumber);
    }

    @GetMapping("/list")
    public List<Integer> listPerfectNumbers(
            @RequestParam(name = "firstNumber") int firstNumber,
            @RequestParam(name = "secondNumber") int secondNumber
    ){

        validateInput(firstNumber, secondNumber);

        return perfectNumberService.listPerfectNumbers(firstNumber, secondNumber);
    }

    private void validateInput(int firstNumber, int secondNumber) {
        if (firstNumber <= 0 || secondNumber <= 0 || firstNumber >= secondNumber) {
            throw new InvalidInputException("Invalid input parameters");
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private static class InvalidInputException extends RuntimeException {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}
