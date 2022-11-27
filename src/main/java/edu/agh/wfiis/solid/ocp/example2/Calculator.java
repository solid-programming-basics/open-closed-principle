package edu.agh.wfiis.solid.ocp.example2;

import java.util.Map;

public class Calculator {
    final private Map<String, MathOperation> mathOperations = Map.of(
            "+", new Addition(),
            "-", new Subtraction(),
            "/", new Division(),
            "*", new Multiplication()
    );
    public double calculate(String[] args) {
        double val1 = Double.parseDouble(args[0]);
        double val2 = Double.parseDouble(args[2]);
        String operator = args[1];

        if (mathOperations.get(operator) == null) {
            throw new IllegalArgumentException(operator + " is not supported");
        }

        if (operator.equals("/") && val2 == 0.0) {
            throw new ArithmeticException("You can not divide by 0");
        }
        return mathOperations.get(operator).operation(val1, val2);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(args));
    }
}
