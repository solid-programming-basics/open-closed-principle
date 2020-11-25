package edu.agh.wfiis.solid.ocp.example2.ArgumentParser;

public class IntegerOperationInput implements OperationInput {
    Integer first;
    Integer second;
    String operator;

    public IntegerOperationInput(Integer first, String operator, Integer second) {
        this.first = first;
        this.second = second;
        this.operator = operator;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    @Override
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
