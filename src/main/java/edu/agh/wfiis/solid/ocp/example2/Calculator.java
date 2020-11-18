package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;
import java.util.Map;

class CalculatorArguments {
    int arg1;
    int arg2;
    String operator;
}

public class Calculator {
    private final Parser parser = new Parser();
    private Map<String, Calculable> functionsByOperators = new HashMap<>() {{
        put("+", new Addition());
        put("-", new Subtraction());
    }};

    public int calculate(String[] args) {
        CalculatorArguments cArgs = parser.parseStringsArray(args);
        if (!functionsByOperators.containsKey(cArgs.operator)) {
            throw new IllegalArgumentException(cArgs.operator + " is not supported");
        }

        int result = functionsByOperators.get(cArgs.operator).calculate(cArgs.arg1, cArgs.arg2);
        return result;
    }

    public void addOperation(String operator, Calculable o) {
        functionsByOperators.put(operator, o);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int res = calculator.calculate(args);
        System.out.println(res);
    }
}

interface Calculable {
    int calculate(int val1, int val2);
}

class Addition implements Calculable {
    @Override
    public int calculate(int val1, int val2) {
        return val1 + val2;
    }
}

class Subtraction implements Calculable {
    @Override
    public int calculate(int val1, int val2) {
        return val1 - val2;
    }
}
