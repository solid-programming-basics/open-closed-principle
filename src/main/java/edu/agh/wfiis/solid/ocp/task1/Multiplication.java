package edu.agh.wfiis.solid.ocp.task1;

public class Multiplication implements Operation {
    @Override
    public int apply(int a, int b) {
        return a * b;
    }
}