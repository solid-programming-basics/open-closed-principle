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
        Number result = underTest.getResult(1, "+", 2);
        Assert.assertEquals(3,result);
    }

    @Test
    public void shouldAddValuesFromTriplet(){
        Triplet parserDummyOutput = new Triplet(1, "+", 2);
        Number result = underTest.getResult(parserDummyOutput);
        Assert.assertEquals(3,result);
    }

    @Test
    public void shouldSubtractValues(){
        Number result = underTest.getResult(1, "-", 2);
        Assert.assertEquals(-1,result);
    }

    @Test
    public void shouldSubtractValuesFromTriplet(){
        Triplet parserDummyOutput = new Triplet(1, "-", 2);
        Number result = underTest.getResult(parserDummyOutput);
        Assert.assertEquals(-1,result);
    }

    @Test
    public void shouldMultiplyValues(){
        Number result = underTest.getResult(2, "*", 3);
        Assert.assertEquals(6,result);
    }

    @Test
    public void shouldMultiplyValuesFromTriplet(){
        Triplet parserDummyOutput = new Triplet(2, "*", 3);
        Number result = underTest.getResult(parserDummyOutput);
        Assert.assertEquals(6,result);
    }

    @Test
    public void shouldDivideValues(){
        Number result = underTest.getResult(10, "/", 2);
        Assert.assertEquals(5,result);
    }

    @Test
    public void shouldDivideValuesFromTriplet(){
        Triplet parserDummyOutput = new Triplet(10, "/", 2);
        Number result = underTest.getResult(parserDummyOutput);
        Assert.assertEquals(5,result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenUnsupportedOperandPassed(){
        underTest.getResult(10, "?", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenUnsupportedOperandPassedInTriplet(){
        Triplet parserDummyOutput = new Triplet(10, "?", 2);
        underTest.getResult(parserDummyOutput);
    }
}
