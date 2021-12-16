package edu.agh.wfiis.solid.ocp.example2;

public class InputParser {

    public static ParsedInput parse(String[] toParse) {
        Double n1 = Double.parseDouble(toParse[0]);
        Double n2 = Double.parseDouble(toParse[2]);
        String operator = toParse[1];

        return new ParsedInput(operator, n1, n2);
    }
}
