package edu.agh.wfiis.solid.ocp.example2;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MathOperationParserTest {

    @Test
    public void shouldCreateCorrectMathOperation(){
        MathOperation mathOperation = MathOperationParser.parse(new String[]{"1", "+", "2"});
        Assert.assertEquals(1, mathOperation.getLhsValues());
        Assert.assertEquals(2, mathOperation.getRhsValue());
        Assert.assertEquals("+", mathOperation.getOperator());
    }

    @Test(expected = NumberFormatException.class)
    public void shouldFailWhenDoubleProvided(){
        MathOperationParser.parse(new String[]{"1.123", "+", "2"});
    }

    @Test(expected = NumberFormatException.class)
    public void shouldFailWhenNotNumberProvided(){
        MathOperationParser.parse(new String[]{"a", "+", "2"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenNotEnoughArguments(){
        MathOperationParser.parse(new String[]{"1", "+"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenTooManyArguments(){
        MathOperationParser.parse(new String[]{"1", "+", "2", "3"});
    }

    @Test(expected = NullPointerException.class)
    public void shouldFailWhenNullAsArgument(){
        MathOperationParser.parse(null);
    }
}