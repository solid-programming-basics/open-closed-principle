package edu.agh.wfiis.solid.ocp.example2;

public class Subtraction implements CalculatingWithOperator {

    @Override
    public int calculate(int val1, int val2) {
        int result = val1 - val2;
        System.out.println(result);
        return result;
    }
}
