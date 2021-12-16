package edu.agh.wfiis.solid.ocp.example2;

public class Addition implements Operation {

    @Override
    public String getKey() {
        return "+";
    }

    @Override
    public Double compute(Double[] numbers) {
        if (numbers.length < 2) throw new IllegalArgumentException("Not enough numbers to perform this operation");
        return numbers[0] + numbers[1];
    }
}
