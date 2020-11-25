package edu.agh.wfiis.solid.ocp.example2;

public class Calculator {

    public int calculate(String[] args) {
        int val1 = Integer.valueOf(args[0]);
        int val2 = Integer.valueOf(args[2]);
        String operator = args[1];

        int result;
        if ("+".equals(operator)) {
            result = val1 + val2;
            System.out.println(result);
            return result;
        } else if ("-".equals(operator)) {
            result = val1 - val2;
            System.out.println(result);
            return result;
        }
        throw new IllegalArgumentException(operator + " is not supported");
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}

interface OperationWithTwoOperands{
    void execute(double firstOperand, double secondOperand);
}

interface InputExtractor{
    void insertInput();
    double getFirstOperand();
    double getSecondOperand();
    OperationWithTwoOperands getOperation();
}

interface ResultAnnouncer{
    void announceResult(double result);
}