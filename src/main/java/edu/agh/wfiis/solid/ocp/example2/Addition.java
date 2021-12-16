package edu.agh.wfiis.solid.ocp.example2;

import java.util.ArrayList;

public class Addition implements Calculatable {

    @Override
    public Integer calculate(ArrayList<Integer> values) {
        Integer returnValue = 0;
        for (int value : values)  returnValue += value;
        return returnValue;
    }
}

