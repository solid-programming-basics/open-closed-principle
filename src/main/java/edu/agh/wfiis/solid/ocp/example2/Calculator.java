package edu.agh.wfiis.solid.ocp.example2;

public class Calculator {

    public int calculate(String[] args) {
        MathematicalOperation mOperation = MathematicalOperationParser.parse(args);

        Calculating calculation = OperationChooser.chooseOperation(mOperation.getOperator());
        int result = calculation.calculate(mOperation.getLeftValue(), mOperation.getRightValue());
        System.out.println(result); 
        return result;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}
