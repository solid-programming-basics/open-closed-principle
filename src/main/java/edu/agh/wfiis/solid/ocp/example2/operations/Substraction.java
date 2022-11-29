package edu.agh.wfiis.solid.ocp.example2.operations;

import edu.agh.wfiis.solid.ocp.example2.Computable;

public class Substraction implements Computable {
    public int compute(int a, int b){
        return a - b;
    }
}