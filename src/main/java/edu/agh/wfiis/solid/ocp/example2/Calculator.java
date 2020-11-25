// package edu.agh.wfiis.solid.ocp.example2;

import java.util.Map;
import java.util.TreeMap;


class Operation {
    public double a;
    public double b;
    public String operator;

    static public Operation parseInput(String[] args) {
        Operation out = new Operation();
        
        out.a = Double.valueOf(args[0]);
        out.b = Double.valueOf(args[2]);
        out.operator = args[1];

        return out;
    }
}


interface Calculation {
    public double execute(double a, double b);
}


class Computer {
    Map<String, Calculation> operations;

    public Computer(Map<String, Calculation> _operations) {
        this.operations = _operations;
    }

    public double calculate(Operation o) {

        for (String key : operations.keySet()) {
            if (key.equals(o.operator)) return operations.get(key).execute(o.a, o.b);
        }

        throw new IllegalArgumentException(o.operator + " is not supported");
    }
}


public class Calculator {

    public static void main(String[] args) {
        Operation op = Operation.parseInput(args);

        Map<String, Calculation> operations = new TreeMap<>();

        operations.put("+", (x, y) -> { return x + y; });
        operations.put("-", (x, y) -> { return x - y; });
        operations.put("/", (x, y) -> { if(y != 0) return x / y; return 0.0; });
        operations.put("m", (x, y) -> { return x * y; });

        Computer comp = new Computer(operations);
        double result = comp.calculate(op);
        System.out.println(result);
    }
}
