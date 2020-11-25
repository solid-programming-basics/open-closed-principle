package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final Map<String, Operation> operators;

    Calculator(){
        operators = new HashMap<>();
        operators.put("+", new Add());
        operators.put("-", new Subtract());
    }

    public int calculate(String[] args) {

        InputExtractor input = new StringTabInputExtractor();

        input.insertInput(args, operators);
        int firstOperand = input.getFirstOperand();
        int secondOperand = input.getSecondOperand();
        Operation operation = input.getOperation();

        int result = operation.execute(firstOperand, secondOperand);

        ResultAnnouncer resultAnnouncer = new ConsoleAnnouncer();
        resultAnnouncer.announceResult(result);
        
        return result;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}

interface Operation{
    int execute(int firstOperand, int secondOperand);
}

interface InputExtractor{
    void insertInput(Object input, Map<String, Operation> operators);
    int getFirstOperand();
    int getSecondOperand();
    Operation getOperation();
}

interface ResultAnnouncer{
    void announceResult(int result);
}

class StringTabInputExtractor implements InputExtractor{

    int firstOperand;
    int secondOperand;
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
    public int getFirstOperand() {
        return firstOperand;
    }

    @Override
    public int getSecondOperand() {
        return secondOperand;
    }

    @Override
    public Operation getOperation() {
        return operation;
    }
}

class Add implements Operation{
    @Override
    public int execute(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }
}

class Subtract implements Operation{
    @Override
    public int execute(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }
}

class ConsoleAnnouncer implements ResultAnnouncer{

    @Override
    public void announceResult(int result) {
        System.out.println(result);
    }
}