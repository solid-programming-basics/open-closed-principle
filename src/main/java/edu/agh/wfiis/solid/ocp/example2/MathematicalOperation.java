package edu.agh.wfiis.solid.ocp.example2;

public class MathematicalOperation
{
    private int leftValue;
    private String operator;
    private int rightValue;

    public MathematicalOperation(int leftValue, String operator, int rightValue)
    {
        this.leftValue = leftValue;
        this.operator = operator;
        this.rightValue = rightValue;
    }

    public int getLeftValue()
    {
        return leftValue;
    }

    public String getOperator()
    {
        return operator;
    }
    
    public int getRightValue()
    {
        return rightValue;
    }
}