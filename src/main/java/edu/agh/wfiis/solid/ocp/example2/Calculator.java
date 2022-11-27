package edu.agh.wfiis.solid.ocp.example2;

import java.math.BigDecimal;
import java.util.Map;

//In command line values and operator should be separated with whitespace
//ex. 12.5 * 2.4
public class Calculator {

    private static final Map<String, ArithmeticOperation> OPERATORS = Map.of(
            "/", new Division(),
            "*", new Multiplication(),
            "+", new Addition(),
            "-", new Subtraction()
    );

    public BigDecimal calculate(String[] args) {

        final var val1 = new BigDecimal(args[0]);
        final var val2 = new BigDecimal(args[2]);
        final var operator = args[1];

        final var operation = OPERATORS.get(operator);

        if (operation == null) {
            throw new IllegalArgumentException(operator + " is not supported");
        }

        return operation.calculate(val1, val2);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        final var result = calculator.calculate(args);
        System.out.println(result);
    }
}
