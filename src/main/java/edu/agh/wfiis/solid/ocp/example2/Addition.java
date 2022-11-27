package edu.agh.wfiis.solid.ocp.example2;

public class Addition implements MathOperation {

    @Override
    public Double operation(Double arg1, Double arg2) {
        return arg1 + arg2;
    }
}
