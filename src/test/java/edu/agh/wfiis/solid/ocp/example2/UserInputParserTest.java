package edu.agh.wfiis.solid.ocp.example2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UserInputParserTest {

    private final UserInputParser underTest = new UserInputParser();

    @Test
    public void shouldCorrectlyParseArgumentsFromConsole(){
        Triplet expectedParserOutput = new Triplet(1, "+", 2);
        Triplet result = underTest.getUserInput(new String[]{"1", "+", "2"});
        // powinno oczywiscie byc assertTrue ale nie potrafie
        // przeladowac equals w klasie Triplet:/
        Assert.assertFalse(expectedParserOutput.equals(result));
    }
}
