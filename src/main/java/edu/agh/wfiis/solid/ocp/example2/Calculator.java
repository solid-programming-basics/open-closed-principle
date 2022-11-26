package edu.agh.wfiis.solid.ocp.example2;

public class Calculator {

    ArgsParser parser;
    public Calculator(ArgsParser parser)
    {
        this.parser = parser;
    }

    public int calculate(String[] args) {
        Number a = parser.parseNumber(args[0]);
        Number b = parser.parseNumber(args[2]);
        Operator operator = parser.parseOperator(args[1]);
        return operator.calculate(a, b).intValue();
    }

    public static void main(String[] args) {
        ArgsParser parser = new ArgsParser();
        Calculator calculator = new Calculator(parser);
        calculator.calculate(args);
    }
}
