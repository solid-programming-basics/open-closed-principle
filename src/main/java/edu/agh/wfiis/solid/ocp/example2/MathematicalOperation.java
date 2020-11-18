package edu.agh.wfiis.solid.ocp.example2;

public class MathematicalOperation
{
    private int leftValue;
    private int rightValue;
    private String operator;

    public MathematicalOperation(int leftValue, int rightValue, String operator)
    {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
        this.operator = operator;
    }

    public int getLeftValue()
    {
        return leftValue;
    }

    public int getRightValue()
    {
        return rightValue;
    }

    public String getOperator()
    {
        return operator;
    }
}