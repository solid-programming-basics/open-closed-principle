package edu.agh.wfiis.solid.ocp.example2;
import java.util.Map;
import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}

public class Calculator {

    private Map<String, CalculatorOperation> calculatorOperations = new HashMap<String, CalculatorOperation>();

    public Calculator(){
        this.calculatorOperations.put("+", new Addition());
        this.calculatorOperations.put("-", new Substraction());
    }

    public double calculate(String[] args) throws IllegalArgumentException{
        Map<String, Double> parsedInputValues = Parser.parse(args);
        String operator = args[1];
        if(this.calculatorOperations.get(operator) == null){
            throw new IllegalArgumentException(operator + " is not supported");
        }
        else{
            System.out.println(this.calculatorOperations.get(operator)
                                                        .perform(parsedInputValues.get("leftValue"), parsedInputValues.get("rightValue")));
            return this.calculatorOperations.get(operator)
                                            .perform(parsedInputValues.get("leftValue"), parsedInputValues.get("rightValue"));
        }
        
    }

}

class Parser{
    public static Map<String, Double> parse(String[] args) throws NumberFormatException{
        Map<String, Double> parsedMap = new HashMap<>();
        parsedMap.put("leftValue", Double.valueOf(args[0]));
        parsedMap.put("rightValue", Double.valueOf(args[2]));
        return parsedMap;
    }
}

interface CalculatorOperation {
    public double perform(double left, double right);
}

class Addition implements CalculatorOperation {

    @Override
    public double perform(double left, double right) {
        return left + right;
    }
}

class Substraction implements CalculatorOperation {

    @Override
    public double perform(double left, double right) {
        return left - right;
    }
}
