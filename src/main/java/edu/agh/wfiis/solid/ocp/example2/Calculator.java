package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private Map<String, CalculatingWithOperator> calculationsByOperator = new HashMap<>();

    Calculator() {
        calculationsByOperator.put("-", new Subtraction());
        calculationsByOperator.put("+", new Addition());
    }

    public int calculate(String[] args) {
        int val1 = Integer.valueOf(args[0]);
        int val2 = Integer.valueOf(args[2]);
        String operator = args[1];

        if (this.calculationsByOperator.get(operator) == null) {
            throw new IllegalArgumentException(operator + " is not supported");
        }

        return this.calculationsByOperator.get(operator).calculate(val1, val2);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}
