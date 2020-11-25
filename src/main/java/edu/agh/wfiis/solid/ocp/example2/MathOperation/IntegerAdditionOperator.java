package edu.agh.wfiis.solid.ocp.example2.MathOperation;

public class IntegerAdditionOperator implements MathOperation<Integer, Integer, Integer> {
    @Override
    public Integer doOperation(Integer first, Integer second) throws ArithmeticException {
        return first + second;
    }
}
