package edu.agh.wfiis.solid.ocp.example2;

import java.math.BigDecimal;

public class Division implements ArithmeticOperation {

    @Override
    public BigDecimal calculate(BigDecimal value1, BigDecimal value2) {
       if(validate(value2)) {
           return value1.divide(value2);
       }
       throw new ArithmeticException("Division by zero");
    }

    private boolean validate(BigDecimal divider){
        return !divider.equals(BigDecimal.ZERO);
    }
}
