package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    Map<String, Calculation> calculationMap = new HashMap<String, Calculation>(){{
        put("+", new Addition());
        put("-", new Subtraction());
    }};

    public int calculate(String[] args) {
        int val1 = Integer.parseInt(args[0]);
        int val2 = Integer.parseInt(args[2]);
        String operator = args[1];

        Calculation calculation = calculationMap.get(operator);
        if(calculation!=null) {
            int result = calculation.calculate(val1, val2);
            System.out.println(result);
            return result;
        }
        throw new IllegalArgumentException(operator + " is not supported");
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}
