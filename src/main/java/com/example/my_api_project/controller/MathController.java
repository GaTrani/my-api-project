package com.example.my_api_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        if (isNumeric(numberOne) && isNumeric(numberTwo)){
            return toDouble(numberOne) + toDouble(numberTwo);
        }else{
            throw new Exception();
        }
    }

    private Double toDouble(String numberString) {
        String numberDouble = numberString.replaceAll(",", ".");
        return  Double.parseDouble(numberDouble);
    }

    private boolean isNumeric(String numberString) {
        String numberStringFormat = numberString.replaceAll(",", ".");
        return  numberStringFormat.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
