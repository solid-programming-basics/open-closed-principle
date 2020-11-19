package edu.agh.wfiis.solid.ocp.example2;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MathematicalOperationParserTest {

    @Test
    public void shouldCreateCorrectMathOperation(){
        MathematicalOperation mOperation = MathematicalOperationParser.parse(new String[]{"1", "+", "2"});
        Assert.assertEquals(1, mOperation.getLhsValues());
        Assert.assertEquals(2, mOperation.getRhsValue());
        Assert.assertEquals("+", mOperation.getOperator());
    }

    @Test(expected = NumberFormatException.class)
    public void shouldFailWhenNotNumberProvided(){
        MathematicalOperationParser.parse(new String[]{"1", "+", "abc"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenNotEnoughArguments(){
        MathematicalOperationParser.parse(new String[]{"1", "+"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenTooManyArguments(){
        MathematicalOperationParser.parse(new String[]{"1", "+", "2", "+", "3"});
    }

    @Test(expected = NullPointerException.class)
    public void shouldFailWhenNullAsArgument(){
        MathematicalOperationParser.parse(null);
    }
}