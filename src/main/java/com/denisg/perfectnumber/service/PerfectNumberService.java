package com.denisg.perfectnumber.service;

import java.util.List;

public interface PerfectNumberService {

    Boolean isPerfectNumber( Integer number);

    List<Integer> listPerfectNumbers(Integer numberA, Integer numberB);
}
