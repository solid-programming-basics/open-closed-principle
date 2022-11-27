package edu.agh.wfiis.solid.ocp.example2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculatorTest {

    private final Calculator underTest = new Calculator();

    @Test
    public void shouldAddValues(){
        double result = underTest.calculate(new String[]{"1", "+", "2"});
        Assert.assertEquals(3.0,result, 0.001);
    }

    @Test
    public void shouldSubtractValues(){
        double result = underTest.calculate(new String[]{"1", "-", "2"});
        Assert.assertEquals(-1.0,result, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenUnsupportedOperandPassed(){
        underTest.calculate(new String[]{"1", "%", "2"});
    }
}
