package edu.agh.wfiis.solid.ocp.example2;

import edu.agh.wfiis.solid.ocp.example2.ArgumentParser.ArgumentParser;
import edu.agh.wfiis.solid.ocp.example2.ArgumentParser.IntegerArgumentParser;
import edu.agh.wfiis.solid.ocp.example2.ArgumentParser.IntegerOperationInput;
import edu.agh.wfiis.solid.ocp.example2.ArgumentParser.OperationInput;
import edu.agh.wfiis.solid.ocp.example2.MathOperation.OperationProcessor;
import edu.agh.wfiis.solid.ocp.example2.ResultPrinter.ResultPrinter;
import edu.agh.wfiis.solid.ocp.example2.ResultPrinter.SuperIntegerPrinter;

public class Calculator {

    public int calculate(String[] args) {
//        int val1 = Integer.valueOf(args[0]);
//        int val2 = Integer.valueOf(args[2]);
//        String operator = args[1];
//        int result;
//        if ("+".equals(operator)) {
//            result = val1 + val2;
//            System.out.println(result);
//            return result;
//        } else if ("-".equals(operator)) {
//            result = val1 - val2;
//            System.out.println(result);
//            return result;
//        }
//        throw new IllegalArgumentException(operator + " is not supported");
        ArgumentParser parser = new IntegerArgumentParser();

        IntegerOperationInput input = (IntegerOperationInput) parser.parseArguments(args);

        Integer result = OperationProcessor.doIntegerOperation(input);

        ResultPrinter<Integer> printer = new SuperIntegerPrinter();

        printer.print(result);

        return result;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}
