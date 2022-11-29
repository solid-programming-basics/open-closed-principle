package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    Map<String, Computative> allowedCalculations = new HashMap<String, Computative>(){{
        put("+", new Addition());
        put("-", new Subtraction());
    }};

    public int calculate(String[] args) {
        int val1 = Integer.valueOf(args[0]);
        int val2 = Integer.valueOf(args[2]);
        String operator = args[1];

        Computative calculation = allowedCalculations.get(operator);
        if (calculation!=null){
            return calculation.compute(val1, val2);
        }

        throw new IllegalArgumentException(operator + " is not supported");
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}
