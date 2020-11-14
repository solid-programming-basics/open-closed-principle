package edu.agh.wfiis.solid.ocp.example2;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.parse(args);

        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(parser.getOperand1(), parser.getOperator(), parser.getOperand2()));
    }
}
