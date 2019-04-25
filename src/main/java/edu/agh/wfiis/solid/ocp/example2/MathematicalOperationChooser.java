package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;
import java.util.Map;

class MathematicalOperationChooser {
    private static Map<String, MathematicalOperation> SUPPORTED_OPERATORS = new HashMap<>();

    static{
        SUPPORTED_OPERATORS.put("*", new Multiplication());
        SUPPORTED_OPERATORS.put("+", new Addition());
        SUPPORTED_OPERATORS.put("-", new Subtraction());
    }

    static MathematicalOperation choose(String operator){
        MathematicalOperation chosenOperation = SUPPORTED_OPERATORS.get(operator);
        if(chosenOperation == null){
            throw new IllegalArgumentException(operator + " is not supported");
        }
        return chosenOperation;
    }
}
