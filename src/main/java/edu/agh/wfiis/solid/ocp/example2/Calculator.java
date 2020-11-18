package edu.agh.wfiis.solid.ocp.example2;

import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    private BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
    private BiFunction<Integer, Integer, Integer> subtract = (a, b) -> a - b;

    private Map<String, BiFunction> operatorToCalculation = Map.of(
            "+", add,
            "-", subtract
    );

    private void validateInputOperator(String operator, Map<String, BiFunction> operatorToCalculation) throws IllegalArgumentException {
        if (!operatorToCalculation.containsKey(operator)) {
            throw new IllegalArgumentException(operator + " is not supported");
        }
    }

    public int calculate(String[] args) {
        int val1 = Integer.valueOf(args[0]);
        int val2 = Integer.valueOf(args[2]);
        String operator = args[1];

        validateInputOperator(operator, operatorToCalculation);

        return (int) operatorToCalculation.get(operator).apply(val1, val2);

    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}