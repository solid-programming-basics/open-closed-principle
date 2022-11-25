package edu.agh.wfiis.solid.ocp.example2;

public class InputParser {
    private final Integer first_value;
    private final String operator;
    private final Integer second_value;

    InputParser(String[] args){
        this.first_value = Integer.parseInt(args[0]);
        this.operator = args[1];
        this.second_value = Integer.parseInt(args[2]);
    }

    Integer getFirstValue(){
        return this.first_value;
    }

    Integer getSecondValue(){
        return this.second_value;
    }

    String getOperator() {
        return this.operator;
    }
}
