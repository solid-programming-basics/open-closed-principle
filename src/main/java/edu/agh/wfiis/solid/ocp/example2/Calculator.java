package edu.agh.wfiis.solid.ocp.example2;

public class Calculator {

    public int calculate(String[] args) {

        OperationDataTriplet triplet = InputParser.parse(args);

        Calculating calculation = new CalculationClient().selectOperation(triplet.getOperator());
        int result = calculation.calculate(triplet.getFirstVal(), triplet.getSecondVal());
        OutputPrinter.print(result);
        return result;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}
