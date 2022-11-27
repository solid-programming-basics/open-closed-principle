package edu.agh.wfiis.solid.ocp.example2;

import java.math.BigDecimal;

public class Multiplication implements ArithmeticOperation {

    @Override
    public BigDecimal calculate(BigDecimal value1, BigDecimal value2) {
        return value1.multiply(value2);
    }
}
