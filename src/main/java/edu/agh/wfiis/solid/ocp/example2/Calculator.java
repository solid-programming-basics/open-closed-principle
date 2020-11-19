//package edu.agh.wfiis.solid.ocp.example2;

import java.util.HashMap;
import java.util.function.BiFunction;

/**
 * Represents calculator class.
 * @author Jakub Perlak
 */
public class Calculator 
{
    /**
     * Addition function.
     */
    private BiFunction<Double, Double, Double> add = (a,b) -> a+b;

    /**
     * Subtraction function.
     */
    private BiFunction<Double, Double, Double> subtract = (a,b) -> a-b;

    /**
     * Exponentiation function.
     */
    private BiFunction<Double, Double, Double> power = (a,b) -> Math.pow(a,b);

    /**
     * HashMap of available functions.
     */
    private HashMap<String, BiFunction> mathOperations;

    /**
     * Class constructor which sets available math operators in Calculator.
     */
    public Calculator()
    {
        mathOperations = new HashMap<>();
        mathOperations.put("+", add);
        mathOperations.put("-", subtract);
        mathOperations.put("^", power);
    }

    /**
     * Method validating the expression.
     * @param args String array which contains expression's arguments and operator.
     * @return ValidationResult which represents the result of validation process.
     */
    private ValidationResult validateExpression(String[] args) 
    {
        ValidationResult validationResult = new ValidationResult();

        if (args.length > 3) 
        {
            validationResult.addError("Too many arguments");
        }

        String operator = args[1];
        if (!mathOperations.containsKey(operator)) 
        {
            validationResult.addError(operator + " is not supported");
        }

        return validationResult;
    }

    /**
     * Method calculating an expression based on given arguments and operator.
     * @param args String array which contains expression's arguments and operator.
     * @return Double which represents the result of given expression.
     */
    public double calculate(String[] args) 
    {
        double var1 = Double.valueOf(args[0]);
        String operator = args[1];
        double var2 = Double.valueOf(args[2]);

        ValidationResult validationResult = validateExpression(args);
        if(validationResult.isValid())
        {
            return (double) mathOperations.get(operator).apply(var1, var2);
        }
        else
        {
            throw new IllegalArgumentException(validationResult.getErrorList());
        }
    }

    /**
     * Main method of the program.
     * @param args String array which contains given arguments.
     */
    public static void main(String[] args) 
    {
        Calculator calculator = new Calculator();
        double res = calculator.calculate(args);
        System.out.println(res);
    }
}

/**
 * Represents validation result class.
 * @author Jakub Perlak
 */
class ValidationResult
{
    /**
     * String represents the list of errors.
     */
    private String errorList = "";
    
    /**
     * Method checking whether the result of validation is correct.
     * @return Boolean which represents whether the result is valid (true) or not (false).
     */
    public boolean isValid()
    {
        return errorList.equals("");
    }

    /**
     * Method adding an error to the list of errors which occured suring the validation process.
     * @param _erros String representing the message of error which occured during the validation process.
     */
    public void addError(String _error)
    {
        errorList += _error + "\n";
    }

    /**
     * Method returning the list of errors during the validation process.
     * @return String which represents the list of errors which occured during validation process.
     */
    public String getErrorList()
    {
        return errorList;
    }
}