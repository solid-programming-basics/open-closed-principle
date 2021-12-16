package edu.agh.wfiis.solid.ocp.example2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(JUnit4.class)
public class CalculatorTest {

    private final Calculator underTest = new Calculator();

    @Test
    public void shouldAddValues(){
        String[] args = new String[]{"+", "1", "2", "3"};
        Parser parser = new Parser();
        ArrayList<Integer> values = parser.parseToInteger(Arrays.copyOfRange(args, 1, args.length));

        int result = underTest.getCalculator(args[0]).calculate(values);
        Assert.assertEquals(6,result);
    }
    @Test
    public void shouldSubtractValues(){
        String[] args = new String[]{"-", "1", "2", "3"};
        Parser parser = new Parser();
        ArrayList<Integer> values = parser.parseToInteger(Arrays.copyOfRange(args, 1, args.length));

        int result = underTest.getCalculator(args[0]).calculate(values);
        Assert.assertEquals(-4, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenUnsupportedOperandPassed(){
        String[] args = new String[]{"/", "1", "2", "3"};
        Parser parser = new Parser();
        ArrayList<Integer> values = parser.parseToInteger(Arrays.copyOfRange(args, 1, args.length));

        int result = underTest.getCalculator(args[0]).calculate(values);
    }
}
