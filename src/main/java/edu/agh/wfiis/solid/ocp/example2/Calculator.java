package edu.agh.wfiis.solid.ocp.example2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Operator> operators;

    public Calculator() {
        this.operators = new ArrayList<Operator>() {
            {
                add(new AdditionStrategy());
                add(new SubtractionStrategy());
            }
        };
    }

    public int calculate(String[] args) {
        int val1 = Integer.parseInt(args[0]);
        int val2 = Integer.parseInt(args[2]);
        String operatorFromArgs = args[1];

        for (Operator operator : operators) {
            if (operator.getOperator().equals(operatorFromArgs)) {
                int result = operator.use(val1, val2);
                System.out.println(result);
                return result;
            }
        }

        throw new IllegalArgumentException(operatorFromArgs + " is not supported");
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}
