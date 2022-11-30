package edu.agh.wfiis.solid.ocp.example2;
// this works for any number of elements:
import java.util.*;   
// import static java.util.Map;


public class Calculator {
    public int calculate(int arg1, int arg2, String operator) {
        Operation operation = operationMap.get(operator);
        
        if (operation) {
            return operation.calculate(arg1, arg2);
        } else {
            throw new IllegalArgumentException(operator + " is not supported");
        }        
    }

    Map<String, Operation> operationMap = Map.ofEntries(
            entry("+", new Addition()),
            entry("-", new Substraction()),
            entry("*", new Multiplication()),

        );

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int arg1 = Integer.valueOf(args[0]);
        int arg2 = Integer.valueOf(args[2]);
        String operator = args[1];        
        calculator.calculate(arg1, arg2, operator);
    }
}

interface Operation {
    public int calculate(int arg1, int arg2);
}

class Addition implements Operation {
    public int calculate(int arg1, int arg2) {
        return arg1 + arg2;
    }
}

class Substraction implements Operation {
    public int calculate(int arg1, int arg2) {
        return arg1 - arg2;
    }
}

class Multiplication implements Operation {
    public int calculate(int arg1, int arg2) {
        return arg1 * arg2;
    }
}

