package edu.agh.wfiis.solid.ocp.example2;

public class Multiplicator implements Calculating
{
    public int calculate(int leftValue, int rightValue)
    {
        return leftValue * rightValue;
    }
}