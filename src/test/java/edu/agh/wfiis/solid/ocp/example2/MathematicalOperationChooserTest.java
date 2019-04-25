package edu.agh.wfiis.solid.ocp.example2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(JUnit4.class)
public class MathematicalOperationChooserTest {

    private MathematicalOperation operation;

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenUnsupportedOperatorPassed(){
        operation =  MathematicalOperationChooser.choose("/");
    }

    @Test
    public void shouldReturnInstanceOfAdditionClass(){
        operation = MathematicalOperationChooser.choose("+");
        assertThat(operation, instanceOf(Addition.class));
    }

    @Test
    public void shouldReturnInstanceOfSubstractionClass(){
        operation = MathematicalOperationChooser.choose("-");
        assertThat(operation, instanceOf(Subtraction.class));
    }

    @Test
    public void shouldReturnInstanceOfMultiplicationClass(){
        operation = MathematicalOperationChooser.choose("*");
        assertThat(operation, instanceOf(Multiplication.class));
    }
}
