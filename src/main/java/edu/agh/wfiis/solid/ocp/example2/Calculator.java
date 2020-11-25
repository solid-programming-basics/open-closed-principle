package edu.agh.wfiis.solid.ocp.example2;

public class Calculator {

    public int calculate(String[] args) {
//        int val1 = Integer.valueOf(args[0]);
//        int val2 = Integer.valueOf(args[2]);
//        String operator = args[1];

        InputExtractor input;   // todo wypelnic implementacja tutaj

        input.insertInput(args);
        double firstOperand = input.getFirstOperand();
        double secondOperand = input.getSecondOperand();
        Operation operation = input.getOperation();

        double result = operation.execute(firstOperand, secondOperand);

        ResultAnnouncer resultAnnouncer; //todo wypelnic

        resultAnnouncer.announceResult(result);

//        int result;
//        if ("+".equals(operator)) {
//            result = val1 + val2;
//            System.out.println(result);
//            return result;
//        } else if ("-".equals(operator)) {
//            result = val1 - val2;
//            System.out.println(result);
//            return result;
//        }
//        throw new IllegalArgumentException(operator + " is not supported");
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
    void insertInput(Object input);
    double getFirstOperand();
    double getSecondOperand();
    Operation getOperation();
}

interface ResultAnnouncer{
    void announceResult(double result);
}