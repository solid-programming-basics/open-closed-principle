package edu.agh.wfiis.solid.ocp.example2;

import static java.util.Map.entry;
import java.util.Set;
import java.util.Map;


public class Calculator {
    private CalculatorInputParser inputParser;
    private Map<String, Calculable> arithmeticalOperationsByOperators = Map.ofEntries(
        entry("+", new Addition()),
        entry("-", new Subtraction()),
        entry("*", new Multiplication())
    );

    {
        this.inputParser = new CalculatorInputParser(this.arithmeticalOperationsByOperators.keySet());
    }

    public int calculate(String[] args) {
        CalculatorInput parsedUserInput = this.inputParser.parse(args);

        int result = this.arithmeticalOperationsByOperators
            .get(parsedUserInput.getOperator())
            .calculate(parsedUserInput.getLeftOperand(), parsedUserInput.getRightOperand());

        return result;
    }
 
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(args);

        System.out.println("Result: " + result);
    }
}



interface Calculable {
    int calculate(int a, int b);
}


class Addition implements Calculable {

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

class Subtraction implements Calculable {

    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}

class Multiplication implements Calculable {

    @Override
    public int calculate(int a, int b) {
        return a * b;
    }
}