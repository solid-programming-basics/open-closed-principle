package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;
import java.util.Map;

public class CalculationChooser {

    private static final Map<String, Calculating> CALCULATIONS_BY_OPERATORS = new HashMap<>();

    static {
        CALCULATIONS_BY_OPERATORS.put("+", new Adder());
        CALCULATIONS_BY_OPERATORS.put("-", new Subtractor());
        CALCULATIONS_BY_OPERATORS.put("*", new Multiplicator());
    }

    public static Calculating chooseCalculation(String operator) {
        Calculating chosenCalculation = CALCULATIONS_BY_OPERATORS.get(operator);
        if (chosenCalculation != null) {
            return chosenCalculation;
        }
        else {
            throw new IllegalArgumentException(operator + " is not supported");
        }
    }
}
