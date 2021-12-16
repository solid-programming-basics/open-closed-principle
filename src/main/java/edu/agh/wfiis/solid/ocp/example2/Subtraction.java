package edu.agh.wfiis.solid.ocp.example2;

import java.util.ArrayList;

public class Subtraction implements Calculatable {

    @Override
    public Integer calculate(ArrayList<Integer> values) {
        int returnValue = values.remove(0);
        for (int value : values)  returnValue -= value;
        return returnValue;
    }
}
