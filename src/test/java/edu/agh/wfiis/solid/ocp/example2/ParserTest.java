package edu.agh.wfiis.solid.ocp.example2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ParserTest {

    @Test
    public void shouldParse() {
        Parser parser = new Parser();
        parser.parse(new String[]{"1", "+", "2"});
        Assert.assertEquals(1, parser.getOperand1());
        Assert.assertEquals("+", parser.getOperator());
        Assert.assertEquals(2, parser.getOperand2());
    }
}
