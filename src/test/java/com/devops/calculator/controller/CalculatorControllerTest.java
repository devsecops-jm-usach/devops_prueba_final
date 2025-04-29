package com.devops.calculator.controller;

import com.devops.calculator.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class CalculatorControllerTest {

    @InjectMocks
    private CalculatorController calculatorController;

    @Mock
    private CalculatorService calculatorService;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateAdd() {
        when(calculatorService.add(anyDouble(), anyDouble())).thenReturn(5.0);

        String viewName = calculatorController.calculate(2, 3, "add", model);

        verify(model).addAttribute("result", 5.0);
        assertEquals("calculator", viewName);
    }

    @Test
    public void testCalculateSubtract() {
        when(calculatorService.subtract(anyDouble(), anyDouble())).thenReturn(-1.0);

        String viewName = calculatorController.calculate(2, 3, "subtract", model);

        verify(model).addAttribute("result", -1.0);
        assertEquals("calculator", viewName);
    }

    @Test
    public void testCalculateMultiply() {
        when(calculatorService.multiply(anyDouble(), anyDouble())).thenReturn(6.0);

        String viewName = calculatorController.calculate(2, 3, "multiply", model);

        verify(model).addAttribute("result", 6.0);
        assertEquals("calculator", viewName);
    }

    @Test
    public void testCalculateDivide() {
        when(calculatorService.divide(anyDouble(), anyDouble())).thenReturn(2.0);

        String viewName = calculatorController.calculate(6, 3, "divide", model);

        verify(model).addAttribute("result", 2.0);
        assertEquals("calculator", viewName);
    }

    @Test
    public void testCalculateDivideByZero() {
        when(calculatorService.divide(anyDouble(), anyDouble())).thenThrow(new IllegalArgumentException("Cannot divide by zero"));

        String viewName = calculatorController.calculate(1, 0, "divide", model);

        verify(model).addAttribute("error", "Cannot divide by zero");
        assertEquals("calculator", viewName);
    }
}