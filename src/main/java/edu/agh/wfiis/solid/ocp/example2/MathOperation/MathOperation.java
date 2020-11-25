package edu.agh.wfiis.solid.ocp.example2.MathOperation;

public interface MathOperation<FirstArgument, SecondArgument, Result> {
    Result doOperation(FirstArgument first, SecondArgument second) throws ArithmeticException;
}
