package edu.agh.wfiis.solid.ocp.example2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(JUnit4.class)
public class OperationChooserTest {

    private final OperationChooser underTest = new OperationChooser();

    @Test
    public void shouldChooseAdder(){
        Calculating chosenOperation = underTest.chooseOperation("+");
        assertThat(chosenOperation, instanceOf(Adder.class));
    }

    @Test
    public void shouldChooseSubtractor() {
        Calculating chosenOperation = underTest.chooseOperation("-");
        assertThat(chosenOperation, instanceOf(Subtractor.class));
    }

    @Test
    public void shouldChooseMultiplicator() {
        Calculating chosenOperation = underTest.chooseOperation("*");
        assertThat(chosenOperation, instanceOf(Multiplicator.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenUnsupportedOperator(){
        Calculating chosenOperation = underTest.chooseOperation("/");
    }

}