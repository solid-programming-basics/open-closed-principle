package edu.agh.wfiis.solid.ocp.example2;

interface Computable{
    public int compute(int value1, int value2);
}

class Addition implements Computable{

    @Override
    public int compute(int value1, int value2) {
        return value1 + value2;
    }
}


class Subtraction implements Computable{

    @Override
    public int compute(int value1, int value2) {
        return value1 - value2;
    }
}

// new operations can be written below
