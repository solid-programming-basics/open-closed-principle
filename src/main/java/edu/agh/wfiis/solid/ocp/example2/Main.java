package edu.agh.wfiis.solid.ocp.example2;

public class Main {
    public static void main(String[] args) {
        UserInputParser calculationParser = new UserInputParser();
        Calculator calculator = new Calculator();
        Triplet calculationDetails = calculationParser.getUserInput(args);
        Number calculationResult = calculator.getResult(calculationDetails);
        System.out.println(calculationResult);

        Triplet newCalculationDetails = new Triplet<Number, String, Number>(
                calculationResult,
                "+",
                5.5);
        calculationResult = calculator.getResult(newCalculationDetails);
        System.out.println(calculationResult);

        calculationResult = calculator.getResult(calculationResult, "*", 2);
        System.out.println(calculationResult);
    }
}
