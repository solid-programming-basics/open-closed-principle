package edu.agh.wfiis.solid.ocp.example2.strategies;

import edu.agh.wfiis.solid.ocp.example2.interfaces.ArithmeticStrategy;

public class DivisionStrategy implements ArithmeticStrategy {
    @Override
    public int execute(int a, int b) throws ArithmeticException {
        if(b == 0)
            throw new ArithmeticException("You cannot divide by zero");
        return a / b;
    }

    @Override
    public String getSymbol() {
        return "/";
    }
}
