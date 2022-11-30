package edu.agh.wfiis.solid.ocp.example2;

import java.util.Map;
import java.util.HashMap;

public class Calculator {

    private Map<String, Computable> operations;

    public Calculator(Map<String, Computable> operations) {

        this.operations = operations;
    }

    public int calculate(int first, int second, String operator) {

        if (this.operations.containsKey(operator)) {
            return operations.get(operator).getResult(first, second);
        }
        else {
            throw new IllegalArgumentException(operator + " is not supported");
        }
    }

    public static void main(String[] args) {

        Map<String, Computable> operations = Map.of(
            "+", new Addition(),  
            "-", new Subtraction()
        );
        Calculator calculator = new Calculator(operations);

        Arguments arguments = ArgumentsParser.parse(args);
        System.out.println(calculator.calculate(arguments.first, arguments.second, arguments.operator));
    }
}