package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;

public class Calculator
{
    {
        if (availableOperations == null) 
        {
            availableOperations = new HashMap<String, Operation>();
            addOperation("+", (a,b)->a+b);
            addOperation("-", (a,b)->a-b);
        }  
    }

    private static HashMap<String, Operation> availableOperations;

    public int calculate(String[] args)
    {
        Operation operation = tryGetOperation(args[1]);
        int[]arguments = parseArguments(args);
        return operation.execute(arguments[0], arguments[1]);
    }

    private int[] parseArguments(String[] args)
    {
        int[] argsParsed = new int[]
        {
            Integer.valueOf(args[0]),
            Integer.valueOf(args[2])
        };
        return argsParsed;
    }

    private Operation tryGetOperation(String operator)
    {
        Operation operation = availableOperations.get(operator);
        if (operation == null) 
        {
            throw new IllegalArgumentException(operator + " is not supported");
        }
        return operation;
    }

    private void addOperation(String operator, Operation operation)
    {
        if (availableOperations == null) 
        {
            throw new NullPointerException("Map of operations not initialized.");
        }
        if (availableOperations.get(operator) != null)
        {
            throw new IllegalArgumentException("Operator \"" + operator + "\" already exists.");
        }
        availableOperations.put(operator, operation);
    }
}
