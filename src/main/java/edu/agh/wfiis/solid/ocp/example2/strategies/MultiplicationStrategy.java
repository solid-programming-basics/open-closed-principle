package edu.agh.wfiis.solid.ocp.example2.strategies;

import edu.agh.wfiis.solid.ocp.example2.interfaces.ArithmeticStrategy;

public class MultiplicationStrategy implements ArithmeticStrategy {
    @Override
    public int execute(int a, int b) throws ArithmeticException {
        return a * b;
    }

    @Override
    public String getSymbol() {
        return "*";
    }
}
