package edu.agh.wfiis.solid.ocp.example2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ParsedInputTest {

    @Test
    public void shouldParseCorrectInput(){
        ParsedInput parsedInput = InputParser.parse(new String[]{"3", "-", "2"});
        Assert.assertEquals(3, parsedInput.getLeftValue());
        Assert.assertEquals("-", parsedInput.getOperator());
        Assert.assertEquals(2, parsedInput.getRightValue());
    }
}
