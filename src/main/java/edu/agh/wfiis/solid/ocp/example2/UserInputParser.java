package edu.agh.wfiis.solid.ocp.example2;

import java.text.NumberFormat;

public class UserInputParser {

    public Triplet<Number, String, Number> getUserInput(String[] args) {
        Number firstOperand = Double.valueOf(args[0]);
        Number secondOperand = Double.valueOf(args[2]);
        String operator = args[1];

        return new Triplet<>(firstOperand,
                             operator,
                             secondOperand);
    }
}
