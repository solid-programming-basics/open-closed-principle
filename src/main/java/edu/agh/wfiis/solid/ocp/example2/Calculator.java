package edu.agh.wfiis.solid.ocp.example2;

public class Calculator {
    
    private int subtraction(int value1, int value2){
        return value1-value2;
    }
        
    private int addition (int value1, int value2){
        return value1+value2;
    }
        
        
    public int calculate(String[] args) {
        
        int val1 = Integer.valueOf(args[0]);
        int val2 = Integer.valueOf(args[2]);
        String operator = args[1];
        
        int result;
        if ("+".equals(operator)) {
            result=addition(val1, val2);
            System.out.println(result);
            return result;
        } else if ("-".equals(operator)) {
            result=subtraction(val1, val2);
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
