package edu.agh.wfiis.solid.ocp.example2;

import java.util.ArrayList;

public class Parser {
    ArrayList<Integer> parseToInteger(String[] values) throws NumberFormatException {
        ArrayList<Integer> result = new ArrayList<>();
        for (String value : values) {
            result.add(Integer.valueOf(value));
        }
        return result;
    }
}
