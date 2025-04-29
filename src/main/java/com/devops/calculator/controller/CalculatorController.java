package com.devops.calculator.controller;

import com.devops.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String index() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam double num1, 
                            @RequestParam double num2, 
                            @RequestParam String operation, 
                            Model model) {
        double result = 0;
        switch (operation) {
            case "add":
                result = calculatorService.add(num1, num2);
                break;
            case "subtract":
                result = calculatorService.subtract(num1, num2);
                break;
            case "multiply":
                result = calculatorService.multiply(num1, num2);
                break;
            case "divide":
                try {
                    result = calculatorService.divide(num1, num2);
                } catch (IllegalArgumentException e) {
                    model.addAttribute("error", e.getMessage());
                    return "calculator";
                }
                break;
        }
        model.addAttribute("result", result);
        return "calculator";
    }
}