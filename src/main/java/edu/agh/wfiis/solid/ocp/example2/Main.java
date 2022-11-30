package edu.agh.wfiis.solid.ocp.example2;

public class Main{

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double result = calculator.calculate(args);
        System.out.println(result);
    }
}
