package edu.agh.wfiis.solid.ocp.example2;

import java.util.Map;

public class Calculator {
    private Map<String, Calculateable> operationsByOperator = Map.of(
        "+", new Addition(),
        "-", new Subtraction()
    );

    private int value1;
    private int value2;
    private String operator;

    public int calculateResult(String[] args){
        parse(args);
        return operationsByOperator.get(operator).calculate(value1, value2);
    }

    @Deprecated
    public int calculate(String[] args) {
        int result = calculateResult(args);
        System.out.println(result);
        return result;
    }

    private void parse(String[] args)
    {
        Parser parser = new Parser(args);
        operator = parser.getOperator();

        if (!operationsByOperator.containsKey(operator)){
            throw new IllegalArgumentException(operator + " is not supported");
        }

        value1 = parser.getVal1();
        value2 = parser.getVal2();
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}


class Parser{
    private String[] operatorAndValues;

    Parser(String[] args){
        this.operatorAndValues = args;
    }

    public int getVal1(){
        return Integer.valueOf(operatorAndValues[0]);
    }

    public int getVal2(){
        return Integer.valueOf(operatorAndValues[2]);
    }

    public String getOperator(){
        return operatorAndValues[1];
    }
}


interface Calculateable{
    public int calculate(int val1, int val2);
}


class Addition implements Calculateable{
    @Override
    public int calculate(int val1, int val2)
    {
        return val1 + val2;
    }
}

class Subtraction implements Calculateable{
    @Override
    public int calculate(int val1, int val2){
        return val1 - val2;
    }
}