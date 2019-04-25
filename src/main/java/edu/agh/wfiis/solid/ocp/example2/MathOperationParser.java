package edu.agh.wfiis.solid.ocp.example2;

public class MathOperationParser {
    public static MathOperation parse(String[] inputData) {
        if(!validateInputLength(inputData))
            throw new IllegalArgumentException(String.format("Number of input values: %d, should be 3", inputData.length));

        int lhsValue = Integer.valueOf(inputData[0]);
        int rhsValue = Integer.valueOf(inputData[2]);
        String operator = inputData[1];

        return new MathOperation(lhsValue, rhsValue, operator);
    }

    private static boolean validateInputLength(String[] inputData) {
        return inputData.length == 3;
    }
}
