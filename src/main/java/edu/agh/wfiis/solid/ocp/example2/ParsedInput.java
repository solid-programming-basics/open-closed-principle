package edu.agh.wfiis.solid.ocp.example2;

class ParsedInput {
    private int leftValue;
    private int rightValue;
    private String operator;

    ParsedInput(int leftValue, int rightValue, String operator){
        this.leftValue = leftValue;
        this.rightValue = rightValue;
        this.operator = operator;
    }

    int getLeftValue(){
        return  this.leftValue;
    }

    int getRightValue(){
        return this.rightValue;
    }

    String getOperator(){
        return this.operator;
    }
}
