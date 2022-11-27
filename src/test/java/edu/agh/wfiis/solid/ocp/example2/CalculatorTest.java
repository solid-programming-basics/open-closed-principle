package edu.agh.wfiis.solid.ocp.example2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

@RunWith(JUnit4.class)
public class CalculatorTest {

    private final Calculator underTest = new Calculator();

    @Test
    public void shouldAddValues(){
        final var result = underTest.calculate(new String[]{"1", "+", "2"});
        Assert.assertEquals(BigDecimal.valueOf(3),result);
    }

    @Test
    public void shouldSubtractValues(){
        final var result = underTest.calculate(new String[]{"1", "-", "2"});
        Assert.assertEquals(BigDecimal.valueOf(-1),result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenUnsupportedOperandPassed(){
        underTest.calculate(new String[]{"1", ":", "2"});
    }

    @Test(expected = ArithmeticException.class)
    public void shouldFailWhenDividerIsZero(){
        underTest.calculate(new String[]{"1", "/", "0.0"});
    }

}
