package edu.agh.wfiis.solid.ocp.example2;

import edu.agh.wfiis.solid.ocp.example2.interfaces.ArithmeticStrategy;
import edu.agh.wfiis.solid.ocp.example2.packageClassScanner.PackageClassScanner;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<ArithmeticStrategy> availableOperations = new ArrayList<>();

    public Calculator() throws Exception {
        List<Class> detectedClasses = new PackageClassScanner().findAllClasses("edu.agh.wfiis.solid.ocp.example2.strategies");
        try {
            for (Class detectedClass: detectedClasses) {
                Constructor<ArithmeticStrategy> constructor = detectedClass.getConstructor();
                availableOperations.add(constructor.newInstance());
            }
        } catch (Exception e) {
            throw new Exception("Error during Calculator creation: one or more classes from strategies package are incorrect", e.getCause());
        }
    }

    public int calculate(String[] args) {
        int val1 = Integer.parseInt(args[0]);
        int val2 = Integer.parseInt(args[2]);
        String operator = args[1];

        for (ArithmeticStrategy operation: availableOperations) {
            if(operation.getSymbol().equals(operator))
                return operation.execute(val1, val2);
        }

        throw new IllegalArgumentException(operator + " is not supported");
    }

    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        calculator.calculate(args);
    }
}
