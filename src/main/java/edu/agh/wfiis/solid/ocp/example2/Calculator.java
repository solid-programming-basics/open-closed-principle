package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private Map<String, Operable> operations = new HashMap<String, Operable>() {{
        put("+", new Addition());
        put("-", new Subtraction());
        put("*", new Multiplication());
        put("/", new Division());
    }};

    public int calculate(int operand1, String operator, int operand2) {

        if (!operations.containsKey(operator)) {
            throw new IllegalArgumentException(operator + " is not supported!");
        }
        return operations.get(operator).operate(operand1, operand2);
    }
}

interface Operable {
    int operate(int operand1, int operand2);
}

class Addition implements Operable {
    public int operate(int operand1, int operand2) {
        return operand1 + operand2;
    }
}

class Subtraction implements Operable {
    public int operate(int operand1, int operand2) {
        return operand1 - operand2;
    }
}

class Multiplication implements Operable {
    public int operate(int operand1, int operand2) {
        return operand1 * operand2;
    }
}

class Division implements Operable {
    public int operate(int operand1, int operand2) {
        return operand1 / operand2;
    }
}
