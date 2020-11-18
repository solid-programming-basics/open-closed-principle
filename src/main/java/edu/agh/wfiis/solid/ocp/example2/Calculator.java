package edu.agh.wfiis.solid.ocp.example2;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class Calculator {

    private int firstValue;
    private int secondValue;
    private String operator;
    private final HashMap<String, Callable<Integer>> mathematicalOperations;

    public Calculator(){
        mathematicalOperations = new HashMap<>();
        mathematicalOperations.put("+", this::addition);
        mathematicalOperations.put("-", this::subtraction);
    }

    private void inputParser(String[] args){
        firstValue = Integer.parseInt(args[0]);
        secondValue = Integer.parseInt(args[2]);
        operator = args[1];
    }

    public int calculate(String[] args) {
        inputParser(args);
        try {
            return mathematicalOperations.get(operator).call();
        } catch (Exception e) {
            throw new IllegalArgumentException(operator + " is not supported");
        }
    }

    private int addition()
    {
        return firstValue + secondValue;
    }

    private int subtraction()
    {
        return firstValue - secondValue;
    }

    public static void main(String[] args){
        Calculator calculator = new Calculator();
        int result = calculator.calculate(args);
        System.out.println(result);
    }
}