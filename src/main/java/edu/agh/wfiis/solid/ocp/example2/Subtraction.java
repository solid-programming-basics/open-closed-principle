package edu.agh.wfiis.solid.ocp.example2;

import java.math.BigDecimal;

public class Subtraction implements ArithmeticOperation {

    @Override
    public BigDecimal calculate(BigDecimal value1, BigDecimal value2) {
        return value1.subtract(value2);
    }
}
