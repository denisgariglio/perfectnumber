package com.denisg.perfectnumber.service.impl;

import com.denisg.perfectnumber.service.PerfectNumberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PerfectNumberServiceImpl implements PerfectNumberService {

    @Override
    public Boolean isPerfectNumber(Integer number) {
        return validatePerfectNumber(number);
    }

    @Override
    public List<Integer> listPerfectNumbers(Integer numberA, Integer numberB) {

        return IntStream.rangeClosed(numberA, numberB)
                .filter(this::isPerfectNumber)
                .boxed().collect(Collectors.toList());
    }

    private Boolean validatePerfectNumber(int number) {

        int divisors = 1;

        divisors += IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .filter(i -> number % i == 0)
                .map(i -> i + (i != number / i ? number / i : 0))
                .sum();

        return divisors == number;
    }

}
