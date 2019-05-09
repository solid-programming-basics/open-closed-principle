package edu.agh.wfiis.solid.ocp.example2;

import java.util.*;

public class CalculationClient {

	private static final Map<String, Calculating> OPERATORS;

	static 
	{
		OPERATORS = new HashMap<String, Calculating>();
		OPERATORS.put("+", new Addition());
		OPERATORS.put("-", new Subtraction());
		OPERATORS.put("*", new Multiplication());
	}

	public Calculating selectOperation(String operator)
	{
		Calculating calculation = OPERATORS.get(operator);
		if (calculation != null)
		{
			return calculation;
		}
		else {
			throw new IllegalArgumentException(operator + " is not supported");
		}
	}
}