package edu.agh.wfiis.solid.ocp.task1;

public class OperationBuilder {
    public static Operation getOperation(String operator){
        switch (operator) {
            case "+":
                return new AdditionOperation();
            case "-":
                return new SubtractionOperation();
            default:
                throw new IllegalArgumentException(operator + " is not supported");
        }
    }
}