package edu.agh.wfiis.solid.ocp.example2;

public class Parser {
    CalculatorArguments parseStringsArray(String[] args) {
        CalculatorArguments res = new CalculatorArguments();
        res.arg1 = Integer.parseInt(args[0]);
        res.arg2 = Integer.parseInt(args[2]);
        res.operator = args[1];
        return res;
    }
}
