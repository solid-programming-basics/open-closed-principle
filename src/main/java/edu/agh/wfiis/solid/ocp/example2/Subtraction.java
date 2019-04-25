package edu.agh.wfiis.solid.ocp.example2;

public class Subtraction implements MathematicalOperation {

    @Override
    public int calculate(int leftValue, int rightValue){
        return leftValue - rightValue;
    }
}
