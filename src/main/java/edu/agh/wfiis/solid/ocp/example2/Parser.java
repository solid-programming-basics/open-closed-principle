package edu.agh.wfiis.solid.ocp.example2;

public class Parser {
    private int operand1;
    private String operator;
    private int operand2;

    public void parse(String[] args) {
        operand1 = Integer.parseInt(args[0]);
        operator = args[1];
        operand2 = Integer.parseInt(args[2]);
    }

    public int getOperand1() {
        return operand1;
    }

    public String getOperator() {
        return operator;
    }

    public int getOperand2() {
        return operand2;
    }
}
