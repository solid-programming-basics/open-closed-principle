package edu.agh.wfiis.solid.ocp.example2;

public interface MathOperable <Output, FirstInput, SecondInput> {
    Output call(FirstInput firstInput, SecondInput secondInput);
}
