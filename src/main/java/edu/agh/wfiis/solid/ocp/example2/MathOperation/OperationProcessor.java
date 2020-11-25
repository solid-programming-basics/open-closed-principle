package edu.agh.wfiis.solid.ocp.example2.MathOperation;

import edu.agh.wfiis.solid.ocp.example2.ArgumentParser.IntegerOperationInput;

import java.util.Map;

public class OperationProcessor {
    // placeholder, jakoś to powinno być zainicjalizowane (np. dependency injection), wstępnie tak
    static Map<String, MathOperation<Integer, Integer, Integer>> integerOperationMap = Map.of("+", new IntegerAdditionOperator(),
            "-", new IntegerSubtractionOperator());

    public static Integer doIntegerOperation(IntegerOperationInput input) throws IllegalArgumentException {
        if(!integerOperationMap.containsKey(input.getOperator()))
            throw new IllegalArgumentException("Operation not supported");

        MathOperation<Integer, Integer, Integer> operation = integerOperationMap.get(input.getOperator());

        return operation.doOperation(input.getFirst(), input.getSecond());
    }
}
