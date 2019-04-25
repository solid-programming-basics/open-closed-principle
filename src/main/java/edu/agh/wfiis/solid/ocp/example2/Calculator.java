package edu.agh.wfiis.solid.ocp.example2;

public class Calculator {

    public int calculate(String[] inputData, HandlingResult resultHandler) {
        MathOperation mathOperation = MathOperationParser.parse(inputData);

        Calculating calculation = CalculationChooser.chooseCalculation(mathOperation.getOperator());
        int result = calculation.calculate(mathOperation.getLhsValues(), mathOperation.getRhsValue());

        resultHandler.handleResult(result);

        return result;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args, new ConsolePrinter());
    }
}
