package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;
import java.util.Map;

public class OperationChooser
{
    private static Map<String, Calculating> OPERATION = new HashMap<>();

    static
    {
        OPERATION.put("+", new Adder());
        OPERATION.put("-", new Subtractor());
        OPERATION.put("*", new Multiplicator());
    }
    
    public static Calculating chooseOperation(String operator)
    {
        Calculating calculation = OPERATION.get(operator).;

        if (calculation != null)
        {
            return calculation;
        }
        else
        {
            throw new IllegalArgumentException(operator + " This operator is not supported");
        }    
    }   
}