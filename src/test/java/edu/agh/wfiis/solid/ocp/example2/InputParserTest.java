package edu.agh.wfiis.solid.ocp.example2;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)

public class InputParserTest{
	
    @Test
    public void shouldCreateCorrectMathOperation(){
        OperationDataTriplet operationDataTriplet = InputParser.parse(new String[]{"1", "+", "2"});
        Assert.assertEquals(1, operationDataTriplet.getFirstVal());
        Assert.assertEquals("+", operationDataTriplet.getOperator());
        Assert.assertEquals(2, operationDataTriplet.getSecondVal());
    }

    @Test(expected = NumberFormatException.class)
    public void shouldFailWhenNotANumberProvided(){
        InputParser.parse(new String[]{"1", "+", "x"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenNotEnoughArguments(){
        InputParser.parse(new String[]{"1", "+"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenTooManyArguments(){
        InputParser.parse(new String[]{"1", "+", "2", "3"});
    }

    @Test(expected = NullPointerException.class)
    public void shouldFailWhenNullAsArgument(){
        InputParser.parse(null);
    }
}