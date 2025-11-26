package edu.agh.wfiis.solid.ocp.task1;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    public Calculator() {
        this.calculatingStrategiesByType = new HashMap<>();
        this.calculatingStrategiesByType.putAll(Map.of(
                "+", new AddStrategy(),
                "-", new SubtractStrategy(),
                "*", new MultiplyStrategy(),
                "/", new DivideStrategy()
        ));
    }

    public Number calculate(String[] args) {
        int val1 = Integer.parseInt(args[0]);
        int val2 = Integer.parseInt(args[2]);
        String operator = args[1];

        CalculatingWithOperator strategy = calculatingStrategiesByType.get(operator);

        if (strategy == null) {
            throw new IllegalArgumentException(operator + " is not supported");
        }
        return strategy.calculate(val1, val2);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }

    private final Map<String, CalculatingWithOperator> calculatingStrategiesByType;

    private interface CalculatingWithOperator {
        Number calculate(int val1, int val2);
    };

    private static class AddStrategy implements CalculatingWithOperator {
        @Override
        public Number calculate(int val1, int val2) {
            Number result = val1 + val2;
            System.out.println(result);
            return result;
        }
    }
    private static class SubtractStrategy implements CalculatingWithOperator {
        @Override
        public Number calculate(int val1, int val2) {
            Number result = val1 - val2;
            System.out.println(result);
            return result;
        }
    }
    private static class MultiplyStrategy implements CalculatingWithOperator {
        @Override
        public Number calculate(int val1, int val2) {
            Number result = val1 * val2;
            System.out.println(result);
            return result;
        }
    }
    private static class DivideStrategy implements CalculatingWithOperator {
        @Override
        public Number calculate(int val1, int val2) {
            if (val2 == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            Number result = (double) val1 / val2;
            System.out.println(result);
            return result;
        }
    }

}
