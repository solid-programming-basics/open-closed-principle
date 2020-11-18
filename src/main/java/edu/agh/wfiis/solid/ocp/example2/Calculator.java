package edu.agh.wfiis.solid.ocp.example2;

public class Calculator {

    public Number getResult(Triplet<Number, String, Number> calculationDetails) {
        return calculate(calculationDetails.first, calculationDetails.second, calculationDetails.third);
    }

    public Number getResult(Number firstOperand, String operator, Number secondOperand) {
        return calculate(firstOperand, operator, secondOperand);
    }

    private Number calculate(Number firstOperand, String operator, Number secondOperand) {
        Number result;

        switch(operator){
            case "+":
                result = firstOperand.doubleValue() + secondOperand.doubleValue();
                break;
            case "-":
                result = firstOperand.doubleValue() - secondOperand.doubleValue();
                break;
            case "*":
                result = firstOperand.doubleValue() * secondOperand.doubleValue();
                break;
            case "/":
                result = firstOperand.doubleValue() / secondOperand.doubleValue();
                break;
            default:
                throw new IllegalArgumentException(operator + " is not supported");
        }
        return result;
    }
}
