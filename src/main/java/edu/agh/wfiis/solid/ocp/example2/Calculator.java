package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private Map<String, OperationProvider> operations = new HashMap<>() {{
        put("+", new AdditionProvider());
        put("-", new SubtractionProvider());
        put("*", new MultiplicationProvider());
        put("/", new DivisionProvider());
    }};

    public int calculate(int operand1, String operator, int operand2) {

        if (!operations.containsKey(operator)) {
            throw new IllegalArgumentException(operator + " is not supported!");
        }
        return operations.get(operator).operate(operand1, operand2);
    }
}

interface OperationProvider {
    int operate(int operand1, int operand2);
}

class AdditionProvider implements OperationProvider {
    public int operate(int operand1, int operand2) {
        return operand1 + operand2;
    }
}

class SubtractionProvider implements OperationProvider {
    public int operate(int operand1, int operand2) {
        return operand1 - operand2;
    }
}

class MultiplicationProvider implements OperationProvider {
    public int operate(int operand1, int operand2) {
        return operand1 * operand2;
    }
}

class DivisionProvider implements OperationProvider {
    public int operate(int operand1, int operand2) {
        return operand1 / operand2;
    }
}
