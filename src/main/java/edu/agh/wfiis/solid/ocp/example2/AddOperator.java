package edu.agh.wfiis.solid.ocp.example2;

public class AddOperator implements Operator{
    public Number calculate(Number first, Number second)
    {
        return first.doubleValue() + second.doubleValue();
    }
}
