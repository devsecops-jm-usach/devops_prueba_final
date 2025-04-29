package com.devops.calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testAdd() {
        assertEquals(5, calculatorService.add(2, 3));
        assertEquals(-1, calculatorService.add(2, -3));
    }

    @Test
    public void testSubtract() {
        assertEquals(-1, calculatorService.subtract(2, 3));
        assertEquals(5, calculatorService.subtract(2, -3));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculatorService.multiply(2, 3));
        assertEquals(-6, calculatorService.multiply(2, -3));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculatorService.divide(6, 3));
        assertEquals(-2, calculatorService.divide(6, -3));
        
        // Test division by zero
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(1, 0));
    }
}