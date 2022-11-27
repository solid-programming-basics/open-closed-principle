package edu.agh.wfiis.solid.ocp.example2;

public class Subtraction implements MathOperation {

    @Override
    public Double operation(Double arg1, Double arg2) {
        return arg1 - arg2;
    }
}
