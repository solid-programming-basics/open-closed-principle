package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final Map<String, Operation> operationMap;

    public Calculator() {
        operationMap = new HashMap<>();
        Operation addition = new Addition();
        Operation subtraction = new Subtraction();
        operationMap.put(addition.getKey(), addition);
        operationMap.put(subtraction.getKey(), subtraction);
    }

    public Double calculate(String operator, Double... numbers) {
        Operation operation = operationMap.get(operator);

        if (operation == null) throw new IllegalArgumentException(operator + " is not supported");

        return operation.compute(numbers);
    }

    @Deprecated
    public int calculate(String[] args) {
        int val1 = Integer.valueOf(args[0]);
        int val2 = Integer.valueOf(args[2]);
        String operator = args[1];

        int result;
        if ("+".equals(operator)) {
            result = val1 + val2;
            System.out.println(result);
            return result;
        } else if ("-".equals(operator)) {
            result = val1 - val2;
            System.out.println(result);
            return result;
        }
        throw new IllegalArgumentException(operator + " is not supported");
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        ParsedInput input = InputParser.parse(args);
        System.out.println(calculator.calculate(input.getOperator(), input.getNumbers()));
    }
}
