package edu.agh.wfiis.solid.ocp.example2;

public class ParsedInput {

    private final String operator;
    private final Double[] numbers;

    public ParsedInput(String operator, Double... numbers) {
        this.operator = operator;
        this.numbers = numbers;
    }

    public String getOperator() {
        return operator;
    }

    public Double[] getNumbers() {
        return numbers;
    }
}
