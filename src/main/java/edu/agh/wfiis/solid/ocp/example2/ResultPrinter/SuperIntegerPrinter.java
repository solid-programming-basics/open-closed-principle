package edu.agh.wfiis.solid.ocp.example2.ResultPrinter;

public class SuperIntegerPrinter implements ResultPrinter<Integer> {
    @Override
    public void print(Integer result) {
        System.out.println(result);
    }
}
