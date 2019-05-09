package edu.agh.wfiis.solid.ocp.example2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(JUnit4.class)

public class CalculationClientTest{

	private final CalculationClient underTest = new CalculationClient();

	@Test
	public void shouldChooseAdditionWhenPlusOperatorPassed(){
		Calculating selectedOperation = underTest.selectOperation("+");
		assertThat(selectedOperation, instanceof(Addition.class));
	}
		
	@Test
	public void shouldChooseSubstractionWhenMinusOperatorPassed(){
		Calculating selectedOperation = underTest.selectOperation("-");
		assertThat(selectedOperation, instanceof(Substraction.class));
	}

	@Test
	public void shouldChooseMultiplicationWhenMultiplicationOperatorPassed(){
		Calculating selectedOperation = underTest.selectOperation("*");
		assertThat(selectedOperation, instanceof(Multiplication.class));
	}


}