package com.denisg.perfectnumber.service;

import com.denisg.perfectnumber.service.impl.PerfectNumberServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PerfectNumberServiceImplTest {

    @Test
    void testIsPerfectNumber() {
        PerfectNumberService perfectNumberService = new PerfectNumberServiceImpl();

        assertTrue(perfectNumberService.isPerfectNumber(28));
        assertFalse(perfectNumberService.isPerfectNumber(12));
    }

    @Test
    void testListPerfectNumbers() {
        PerfectNumberService perfectNumberService = new PerfectNumberServiceImpl();

        assertEquals(List.of(1, 6, 28), perfectNumberService.listPerfectNumbers(1, 30));
        assertEquals(List.of(), perfectNumberService.listPerfectNumbers(10, 20));
    }

    @Test
    void testListPerfectNumbersWithInvalidRange() {
        PerfectNumberService perfectNumberService = new PerfectNumberServiceImpl();

        assertThrows(IllegalArgumentException.class,
                () -> perfectNumberService.listPerfectNumbers(20, 10));
    }

}
