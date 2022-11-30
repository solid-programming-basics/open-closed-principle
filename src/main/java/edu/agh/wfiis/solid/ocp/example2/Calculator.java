package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;
import java.util.Map;

class Calculator {
    private int value1;
    private int value2;
    private char operator;

    private Map<Character, Computable> availableComputations = new HashMap<>();

    {
        availableComputations.put('+', new Addition());
        availableComputations.put('-', new Subtraction());
    }

    void parse(String[] computation){
        this.value1 = Integer.parseInt(computation[0]);
        this.value2 = Integer.parseInt(computation[2]);
        this.operator = computation[1].charAt(0);
    }

    public int calculate(String[] args) {
        parse(args);
        int result;
        Computable computation = availableComputations.get(this.operator);

        if (computation == null) {
            throw new IllegalArgumentException(operator + " is not supported");
        }

        result = computation.compute(this.value1, this.value2);
        return result;
    }
}
