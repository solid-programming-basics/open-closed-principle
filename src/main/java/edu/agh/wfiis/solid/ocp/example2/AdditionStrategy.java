package edu.agh.wfiis.solid.ocp.example2;

public class AdditionStrategy implements Operator {
    @Override
    public String getOperator() {
        return "+";
    }

    @Override
    public int use(int l, int r) {
        return l + r;
    }
}
