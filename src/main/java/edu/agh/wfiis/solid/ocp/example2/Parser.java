package edu.agh.wfiis.solid.ocp.example2;

public class Parser {
    private int operand1;
    private String operation;
    private int operand2;

    void parse(String[] args) {
        operand1 = Integer.parseInt(args[0]);
        operation = args[1];
        operand2 = Integer.parseInt(args[2]);
    }

    public int getOperand1() {
        return operand1;
    }

    public String getOperation() {
        return operation;
    }

    public int getOperand2() {
        return operand2;
    }
}
