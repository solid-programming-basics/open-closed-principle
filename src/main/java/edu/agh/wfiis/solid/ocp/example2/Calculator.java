package edu.agh.wfiis.solid.ocp.example2;


import edu.agh.wfiis.solid.ocp.example2.operations.Addition;
import edu.agh.wfiis.solid.ocp.example2.operations.Substraction;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final Map<String, Computable> operationsByOperator = new HashMap<String, Computable>() {{
        put("+",new Addition());
        put("-",new Substraction());
    }};

    public int calculate(String[] args) {
        int val1 = Integer.parseInt(args[0]);
        int val2 = Integer.parseInt(args[2]);
        String operator = args[1];

        try {
            int result = this.operationsByOperator.get(operator).compute(val1, val2);
            System.out.println(result);
            return result;
        }
        catch(NullPointerException e) {
            throw new IllegalArgumentException(operator + " is not supported");
        }
    }

    public static void main(String[] args) {
        edu.agh.wfiis.solid.ocp.example2.Calculator calculator = new edu.agh.wfiis.solid.ocp.example2.Calculator();
        calculator.calculate(args);
    }
}