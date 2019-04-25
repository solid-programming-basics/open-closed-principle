package edu.agh.wfiis.solid.ocp.example2;

public class Calculator {

    int calculate(String[] args) {
        ParsedInput input = InputParser.parse(args);
        MathematicalOperation operation = MathematicalOperationChooser.choose(input.getOperator());

        return operation.calculate(input.getLeftValue(), input.getRightValue());
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(args));
    }
}