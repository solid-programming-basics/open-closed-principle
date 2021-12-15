package edu.agh.wfiis.solid.ocp.example2.interfaces;

public interface ArithmeticStrategy {
    int execute(int a, int b) throws ArithmeticException;
    String getSymbol();
}
