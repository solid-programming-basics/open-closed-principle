package edu.agh.wfiis.solid.ocp.task1;

public class Calculator {

    public Number calculate(String[] args) {
        int val1 = Integer.valueOf(args[0]);
        int val2 = Integer.valueOf(args[2]);
        String operator = args[1];

        Operation operation = OperationBuilder.getOperation(operator);
        return operation.doOperation(val1, val2);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}
