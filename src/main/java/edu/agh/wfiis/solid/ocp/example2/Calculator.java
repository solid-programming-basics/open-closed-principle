package edu.agh.wfiis.solid.ocp.example2;

import edu.agh.wfiis.solid.ocp.example2.strategy.CalculationStrategy;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final Map<String, CalculationStrategy> operatorToCalculationStrategyMap;

    public Calculator(Map<String, CalculationStrategy> operatorToCalculationStrategyMap) {
        this.operatorToCalculationStrategyMap = operatorToCalculationStrategyMap;
    }

    public static Calculator addAndSubtract() {
        return new Calculator(createAddAndSubtractMap());
    }

    public int calculate(String[] args) {
        int val1 = Integer.parseInt(args[0]);
        int val2 = Integer.parseInt(args[2]);
        String operator = args[1];

        try {
            return operatorToCalculationStrategyMap.get(operator).calculate(val1, val2);
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException(npe.getMessage());
        }
    }

    public static void main(String[] args) {
        Calculator calculator = Calculator.addAndSubtract();
        calculator.calculate(args);
    }

    private static Map<String, CalculationStrategy> createAddAndSubtractMap() {
        Map<String, CalculationStrategy> calculatorOperationsMap = new HashMap<>();
        calculatorOperationsMap.put("+", Integer::sum);
        calculatorOperationsMap.put("-", (firstNumber, secondNumber) -> firstNumber - secondNumber);
        return calculatorOperationsMap;
    }
}
