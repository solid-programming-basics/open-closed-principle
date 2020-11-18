package edu.agh.wfiis.solid.ocp.example2;

public class Calculator {

    public int calculate(String[] args) {
        MathematicalOperation mOperation = MathematicalOperationParser.parse(args);


        

        // int result;
        // if ("+".equals(operator)) {
        //     result = val1 + val2;
        //     System.out.println(result);
        //     return result;
        // } else if ("-".equals(operator)) {
        //     result = val1 - val2;
        //     System.out.println(result);
        //     return result;
        // }
        // throw new IllegalArgumentException(operator + " is not supported");
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}
