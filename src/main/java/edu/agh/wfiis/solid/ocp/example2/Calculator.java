package edu.agh.wfiis.solid.ocp.example2;
import java.util.HashMap;

public class Calculator {
    private final HashMap<String, MathOperable<Integer, Integer, Integer>> mathOperations;

    Calculator() {
        this.mathOperations = new HashMap<>();
        this.mathOperations.put("+", this::add);
        this.mathOperations.put("-", this::subtract);
    }

    private Integer add(Integer first_value, Integer second_value){
        return first_value + second_value;
    }

    private Integer subtract(Integer first_value, Integer second_value){
        return first_value - second_value;
    }

    public Integer calculate(String[] args) {
        InputParser input = new InputParser(args);

        try {
            return this.mathOperations.get(input.getOperator()).call(input.getFirstValue(), input.getSecondValue());
        } catch (Exception e) {
            throw new IllegalArgumentException(input.getOperator() + " is not supported");
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(args));
    }
}
