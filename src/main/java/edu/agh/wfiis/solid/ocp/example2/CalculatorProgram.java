package edu.agh.wfiis.solid.ocp.example2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class CalculatorProgram{
    public static void main(String... args){
        if(!BiArithmeticOperationFormatValidator.isValid(args)){
            throw new IllegalArgumentException("Arithmetic operation format not valid!");
        }

        Calculator calculator = new Calculator();
        double result = calculator.calculate(BiArithmeticOperationParser.parse(args));
        System.out.println("The results is: " + result);
    }
}

class Calculator {

    private final List<BiArithmeticOperation> supportedOperations = List.of(
        new Add(), new Subtract(), new Multiply(), new Divide()
    );
    private final Map<String, BiArithmeticOperation> supportedOperationsByOperators = supportedOperations.stream().collect(
            Collectors.toMap(BiArithmeticOperation::getOperator, biArithmeticOperation -> biArithmeticOperation)
    );

    private boolean doesSupportOperation(String operator){
        return this.supportedOperationsByOperators.containsKey(operator);
    }

    public double calculate(BiArithmeticOperationArguments operationArguments) {
        if(!doesSupportOperation(operationArguments.operator)){
            throw new IllegalArgumentException("Operator " + operationArguments.operator + " is not supported");
        }
        return supportedOperationsByOperators.get(operationArguments.operator).perform(operationArguments.lhs, operationArguments.rhs);
    }
}

interface HavingArithmeticOperator{
    String getOperator();
}

interface BiArithmeticallyPerformable{
    Double perform(Double lhs, Double rhs);
}

interface BiArithmeticOperation extends HavingArithmeticOperator, BiArithmeticallyPerformable{ }

class Add implements BiArithmeticOperation{

    @Override
    public String getOperator() {
        return "+";
    }

    @Override
    public Double perform(Double lhs, Double rhs) {
        return lhs+rhs;
    }
}

class Subtract implements BiArithmeticOperation{

    @Override
    public String getOperator() {
        return "-";
    }

    @Override
    public Double perform(Double lhs, Double rhs) {
        return lhs-rhs;
    }
}

class Multiply implements BiArithmeticOperation{

    @Override
    public String getOperator() {
        return "*";
    }

    @Override
    public Double perform(Double lhs, Double rhs) {
        return rhs*lhs;
    }
}

class Divide implements BiArithmeticOperation{

    @Override
    public String getOperator() {
        return "/";
    }

    @Override
    public Double perform(Double lhs, Double rhs) {
        if(rhs==0){
            return 0d;
        }
        return lhs/rhs;
    }
}

final class BiArithmeticOperationFormatValidator{

    private BiArithmeticOperationFormatValidator(){}

    private static final String arithmeticOperatorRegex = "[+%*/-]";

    public static boolean isValid(String... operation){
        return doesContainProperNumberOfArguments(operation) && isNumber(operation[0]) && isNumber(operation[2]) && isArithmeticOperator(operation[1]);
    }

    private static boolean doesContainProperNumberOfArguments(String... operation){
        return operation.length==3;
    }

    private static boolean isNumber(String value){
        try{
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException numberFormatException){
            return false;
        }
    }

    public static boolean isArithmeticOperator(String value){
        return value.matches(arithmeticOperatorRegex);
    }

}

final class BiArithmeticOperationParser{

    private BiArithmeticOperationParser(){}

    public static BiArithmeticOperationArguments parse(String... args){
        BiArithmeticOperationArguments arguments = new BiArithmeticOperationArguments();
        arguments.lhs = Double.parseDouble(args[0]);
        arguments.operator = args[1];
        arguments.rhs = Double.parseDouble(args[2]);
        return arguments;
    }

}

class BiArithmeticOperationArguments{
    public Double rhs;
    public String operator;
    public Double lhs;
}

