package edu.agh.wfiis.solid.ocp.example2;

public class Calculator {
    private int valueA;
    private int valueB;
    private String operator;

    public int calculate(String[] args){
        parseInput(args);
        int result = calculateResult();

        return result;
    }

    private void parseInput(String[] args) {
        if(args.length == 3){
            parseOperator(args);
            parseValues(args);
        }else{
            throw new IllegalArgumentException("Wrong number of arguments");
        }
    }

    private void parseOperator(String[] args) {
        operator = args[1];
    }

    private void parseValues(String[] args) {
        valueA = Integer.parseInt(args[0]);
        valueB = Integer.parseInt(args[2]);
    }

    private int calculateResult() {
        switch (operator){
            case "+":
                return addition();
            case "-":
                return subtraction();
            default:
                throw new IllegalArgumentException("[" + operator + "] operator is not supported");
        }
    }

    private int addition() {
        return valueA + valueB;
    }

    private int subtraction() {
        return valueA - valueB;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}
