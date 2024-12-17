package edu.agh.wfiis.solid.ocp.task1;

public class Subtraction implements Operation {
    @Override
    public int apply(int a, int b) {
        return a - b;
    }
}