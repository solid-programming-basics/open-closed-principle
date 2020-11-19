package edu.agh.wfiis.solid.ocp.example2;

public class MathematicalOperationParser
{
    public static MathematicalOperation parse(String[] args)
    {
        if (args.length != 3)
        {
            throw new IllegalArgumentException("Wrong number of arguments. Expected two numbers separeted by operator");
        }

        int leftValue = Integer.valueOf(args[0]);
        String operator = args[1];
        int rightValue = Integer.valueOf(args[2]);

        return new MathematicalOperation(leftValue, operator, rightValue);
    }
}