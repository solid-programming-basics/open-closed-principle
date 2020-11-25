package edu.agh.wfiis.solid.ocp.example2.ArgumentParser;

public class IntegerArgumentParser implements ArgumentParser {
    @Override
    public OperationInput parseArguments(String[] args) {
        int val1 = Integer.parseInt(args[0]);
        int val2 = Integer.parseInt(args[2]);
        String operator = args[1];

        return new IntegerOperationInput(val1, operator, val2);
    }
}
