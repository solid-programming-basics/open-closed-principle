package edu.agh.wfiis.solid.ocp.example2;

import java.util.*;

public class Main{
  public static void main(String[] args) {
          Calculator calculator = new Calculator();
          double result = calculator.calculate(args);
          System.out.println(result);
      }
}

interface MakingOperation 
{
  public double operate(double firstArgument, double secondArgument);
}

class Addition implements MakingOperation
{
  public double operate(double firstArgument, double secondArgument)
  {
    return firstArgument + secondArgument;
  }
}

class Substraction implements MakingOperation
{
  public double operate(double firstArgument, double secondArgument)
  {
    return firstArgument - secondArgument;
  }
}

class Multiplication implements MakingOperation
{
  public double operate(double firstArgument, double secondArgument)
  {
    return firstArgument * secondArgument;
  }
}

class Division implements MakingOperation{
  public double operate(double firstArgument, double secondArgument)
  {
    if(secondArgument == 0)
    {
      throw new ArithmeticException("Dividing by 0 attemption!");
    }
    return firstArgument / secondArgument;
  }
}

class OperationParser{
  private double firstArgument;
  private double secondArgument;
  private char operator;

  void parse(String[] args)
  {
    firstArgument = Double.valueOf(args[0]);
    secondArgument = Double.valueOf(args[2]);
    operator = args[1].charAt(0);
  }

  public double getFirstArgument()
  {
    return firstArgument;
  }

  public double getSecondArgument()
  {
    return secondArgument;
  }

  public char getOperator()
  {
    return operator;
  }
}

class Calculator {
    private Map<Character, MakingOperation> operationMap;

    Calculator()
    {
      initOperationMap();
    }

    private void initOperationMap() {
      operationMap = new HashMap<Character, MakingOperation>();
      operationMap.put('+', new Addition());
      operationMap.put('-', new Substraction());
      operationMap.put('*', new Multiplication());
      operationMap.put('/', new Division());
    }

    public double calculate(String[] args) {
      OperationParser parser = new OperationParser();
      parser.parse(args);
      
      MakingOperation operation = getOperation(parser);

      return getResult(parser, operation);
    }

    private double getResult(OperationParser parser, MakingOperation operation)
    {
      double firstArgument = parser.getFirstArgument();
      double secondArgument = parser.getSecondArgument();
      
      return operation.operate(firstArgument, secondArgument);
    }

    private MakingOperation getOperation(OperationParser parser) throws IllegalArgumentException
    {
      char operator = parser.getOperator();
      MakingOperation operation = operationMap.get(operator);

      if(operation == null)
      {
        throw new IllegalArgumentException("Unsupported operation provided!");
      }

      return operation;
    }
}