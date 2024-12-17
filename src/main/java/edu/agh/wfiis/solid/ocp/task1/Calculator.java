package edu.agh.wfiis.solid.ocp.task1;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final Map<String, Operation> operations = new HashMap<>();

    public Calculator() {
        operations.put("+", new Addition());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiplication());
    }

    public Number calculate(String[] args) {
        int val1 = Integer.valueOf(args[0]);
        int val2 = Integer.valueOf(args[2]);
        String operator = args[1];

        Operation operation = operations.get(operator);
        if (operation == null) {
            throw new IllegalArgumentException(operator + " is not supported");
        }

        int result = operation.apply(val1, val2);
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}
