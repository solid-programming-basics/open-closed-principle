package edu.agh.wfiis.solid.ocp.example2;

public class MathOperation {
    private int lhsValues;
    private int rhsValue;
    private String operator;

    public MathOperation(int lhsValues, int rhsValue, String operator) {
        this.lhsValues = lhsValues;
        this.rhsValue = rhsValue;
        this.operator = operator;
    }

    public int getLhsValues() {
        return lhsValues;
    }

    public int getRhsValue() {
        return rhsValue;
    }

    public String getOperator() {
        return operator;
    }
}
