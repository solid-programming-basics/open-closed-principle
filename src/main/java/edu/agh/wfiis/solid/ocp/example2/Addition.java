package edu.agh.wfiis.solid.ocp.example2;

public final class Addition implements Computative{

    @Override
    public int compute(int a, int b){
        return a + b;
    }
}
