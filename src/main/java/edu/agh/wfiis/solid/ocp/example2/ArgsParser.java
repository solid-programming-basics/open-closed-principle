package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;

public class ArgsParser {
    private HashMap<String, Operator> operatorsMap;

    public ArgsParser() {
        operatorsMap = new HashMap<String, Operator>();
        operatorsMap.put("+", new AddOperator());
        operatorsMap.put("-", new SubtractOperator());
        operatorsMap.put("*", new MultiplyOperator());
        // operatorsMap.put("/", new DivideOperator());
    }

    public Number parseNumber(String arg) {
        return Double.parseDouble(arg);
    }

    public Operator parseOperator(String arg) {
        if (operatorsMap.get(arg) != null) {
            return operatorsMap.get(arg);
        } else {
            throw new IllegalArgumentException(arg + "is not supported");
        }
    }
}
