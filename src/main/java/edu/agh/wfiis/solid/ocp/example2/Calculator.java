package edu.agh.wfiis.solid.ocp.example2;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            System.out.println(calculator.calculate(args));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}


class Calculator {
    private Map<String, ComputableOperation> operationOperators = new HashMap<String, ComputableOperation>();

    public Calculator() {
        operationOperators.put("+", new Addition());
        operationOperators.put("-", new Subtraction());
        operationOperators.put("*", new Multiplication());
        operationOperators.put("/", new Division());
        operationOperators.put("sqrt", new SquareN());
        operationOperators.put("pow", new Power());
    }

    public double calculate(String[] args) {
        InputParser inputParser = new InputParser(this.operationOperators.keySet());
        ParsedExpression parsedExpression = inputParser.parse(args);

        return this.operationOperators.get(parsedExpression.operator).compute(parsedExpression.left, parsedExpression.right);
    }

}

class ParsedExpression {
    public double left;
    public double right;
    public String operator;

    public ParsedExpression(double left, double right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }
}

class InputParser {
    private Set<String> allowedOperators;

    public InputParser(Set<String> allowedOperators) {
        this.allowedOperators = allowedOperators;
    }

    public ParsedExpression parse(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Pass 3 arguments: [left] [operator] [right]");
        }

        String operator = args[1];
        if (isOperatorForbidden(operator)) {
            throw new IllegalArgumentException(String.format("Operator %s is forbidden!", operator));
        }

        double left = Double.parseDouble(args[0]);
        double right = Double.parseDouble(args[2]);

        return new ParsedExpression(left, right, operator);
    }

    private boolean isOperatorForbidden(String op) {
        return !this.allowedOperators.contains(op);
    }
}


interface ComputableOperation {
    public double compute(double left, double right);
}

class Addition implements ComputableOperation {
    public double compute(double left, double right) {
        return left + right;
    }
}

class Subtraction implements ComputableOperation {
    public double compute(double left, double right) {
        return left - right;
    }
}

class Multiplication implements ComputableOperation {
    public double compute(double left, double right) {
        return left * right;
    }
}

class Division implements ComputableOperation {
    public double compute(double left, double right) {
        if (right == 0) {
            throw new ArithmeticException(String.format("Can't divide by 0, operation was %f / %f", left, right));
        }
        return left / right;
    }
}

class SquareN implements ComputableOperation {
    public double compute(double left, double right) {
        if (right % 2 == 0 && left < 0) {
            throw new ArithmeticException(String.format("Square%.0f not possible for value < 0, operation was sqrt(%f)", right, left));
        }
        return Math.pow(left, 1 / right);
    }
}

class Power implements ComputableOperation {
    public double compute(double left, double right) {
        return Math.pow(left, right);
    }
}