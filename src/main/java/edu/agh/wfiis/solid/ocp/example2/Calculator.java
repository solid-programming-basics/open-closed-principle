package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final Map<String, Operation> operators;
    private final InputExtractor inputExtractor;
    private final ResultLogger resultLogger;

    {
        operators = new HashMap<>();
        operators.put("+", new Add());
        operators.put("-", new Subtract());
    }

    Calculator(){
        this(new StringTabInputExtractor(), new ConsoleLogger());
    }

    Calculator(InputExtractor inputExtractor, ResultLogger resultLogger){
        this.inputExtractor = inputExtractor;
        this.resultLogger = resultLogger;
    }

    public double performCalculations(Object inputArgs){
        return calculateFromInput(inputArgs);
    }

    @Deprecated
    public int calculate(String[] args) {
        int result = (int) calculateFromInput(args);
        resultLogger.announceResult(result);
        return result;
    }

    private double calculateFromInput(Object inputArgs){
        inputExtractor.insertInput(inputArgs, operators);
        double firstOperand = inputExtractor.getFirstOperand();
        double secondOperand = inputExtractor.getSecondOperand();
        Operation operation = inputExtractor.getOperation();

        return operation.execute(firstOperand, secondOperand);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}

interface Operation{
    double execute(double firstOperand, double secondOperand);
}

interface InputExtractor{
    void insertInput(Object input, Map<String, Operation> operators);
    double getFirstOperand();
    double getSecondOperand();
    Operation getOperation();
}

interface ResultLogger {
    void announceResult(double result);
}

class StringTabInputExtractor implements InputExtractor{

    double firstOperand;
    double secondOperand;
    Operation operation;

    @Override
    public void insertInput(Object input, Map<String, Operation> operators) {
        String[] args = (String[]) input;
        firstOperand = Integer.parseInt(args[0]);
        secondOperand = Integer.parseInt(args[2]);
        String operator = args[1];
        operation = operators.get(operator);
        if (operation == null)
            throw new IllegalArgumentException(operator + " is not supported");
    }

    @Override
    public double getFirstOperand() {
        return firstOperand;
    }

    @Override
    public double getSecondOperand() {
        return secondOperand;
    }

    @Override
    public Operation getOperation() {
        return operation;
    }
}

class Add implements Operation{
    @Override
    public double execute(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }
}

class Subtract implements Operation{
    @Override
    public double execute(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }
}

class ConsoleLogger implements ResultLogger {

    @Override
    public void announceResult(double result) {
        System.out.println(result);
    }
}