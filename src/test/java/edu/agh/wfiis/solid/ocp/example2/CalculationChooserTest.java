package edu.agh.wfiis.solid.ocp.example2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(JUnit4.class)
public class CalculationChooserTest {

    private final CalculationChooser underTest = new CalculationChooser();

    @Test
    public void shouldChooseAdderWhenPlusOperatorPassed(){
        Calculating chosenCalculation = underTest.chooseCalculation("+");
        assertThat(chosenCalculation, instanceOf(Adder.class));
    }

    @Test
    public void shouldChooseSubtractorWhenMinusOperatorPassed() {
        Calculating chosenCalculation = underTest.chooseCalculation("-");
        assertThat(chosenCalculation, instanceOf(Subtractor.class));
    }

    @Test
    public void shouldChooseMultiplicatorWhenAsteriskOperatorPassed() {
        Calculating chosenCalculation = underTest.chooseCalculation("*");
        assertThat(chosenCalculation, instanceOf(Multiplicator.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenUnsupportedOperatorPassed(){
        Calculating chosenCalculation = underTest.chooseCalculation("/");
    }

}
