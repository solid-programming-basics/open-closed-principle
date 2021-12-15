package edu.agh.wfiis.solid.ocp.example2;
import java.util.HashMap;
import java.util.Map;

public class Calculator 
{
    private final Map<String, AritmeticOperation> givenOperations = new HashMap<>()
    {{
        put("+", new Add());
        put("-", new Subtract());
    }};

    public int calculate(String[] args) {
        AritmeticOperationArguments arguments = Parser.parse(args);

        if(givenOperations.containsKey(arguments.aperation))
        {
            Double result = givenOperations.get(arguments.operation).calculate(arguments.firstValue, arguments.secondValue);
            return result;
        }
        else
        {
            throw new IllegalArgumentException(arguments.operation + " is not supported");
        }
    }

    public static void main(String[] args) 
    {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}

interface AritmeticOperation
{
    Double calculate(Double firstValue, Double secondValue);
}

class Add implements AritmeticOperation
{
    @Override
    public Double calculate(Double firstValue, Double secondValue)
    {
        return firstValue + secondValue;
    }
}

class Subtract implements AritmeticOperation
{
    @Override
    public Double calculate(Double firstValue, Double secondValue)
    {
        return firstValue - secondValue;
    }
}

final class Parser
{
    public static AritmeticOperationArguments parse(String[] args)
    {
        AritmeticOperationArguments arguments = new AritmeticOperationArguments();
        arguments.firstValue = Double.parseDouble(args[0]);
        arguments.secondValue = Double.parseDouble(args[2]);
        arguments.operation = args[1];
        return arguments;
    }
}

class AritmeticOperationArguments
{
    public Double firstValue;
    public Double secondValue;
    public Double operation;
}
