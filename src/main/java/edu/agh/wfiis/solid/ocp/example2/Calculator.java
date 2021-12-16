package edu.agh.wfiis.solid.ocp.example2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

;

public class Calculator {
    private Map<String, Calculatable> calculatorStrategiesByType = new HashMap<>();
    Calculator() {
        this.calculatorStrategiesByType.put("+", new Addition());
        this.calculatorStrategiesByType.put("-", new Subtraction());
}
    Calculatable getCalculator(String operator) throws IllegalArgumentException {
        if(this.calculatorStrategiesByType.get(operator) == null) throw new IllegalArgumentException(operator + " is not supported");
        return this.calculatorStrategiesByType.get(operator);
    }

    public static void main(String[] args) {
       Calculator calculator = new Calculator();
       Parser parser = new Parser();
       ArrayList<Integer> values = parser.parseToInteger(Arrays.copyOfRange(args, 1, args.length));
       int result = calculator.getCalculator(args[0]).calculate(values);
    }
}

