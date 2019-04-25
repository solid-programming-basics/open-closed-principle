package edu.agh.wfiis.solid.ocp.example2;

class InputParser {
     static ParsedInput parse(String[] inputString){

        if(validateInput(inputString)) {
            int leftValue = Integer.valueOf(inputString[0]);
            int rightValue = Integer.valueOf(inputString[2]);
            String operation = inputString[1];

            return new ParsedInput(leftValue, rightValue, operation);
        }

        throw new IllegalArgumentException("Bad number of input arguments. Expected 3");
    }

    private static Boolean validateInput(String[] inputString){
        return inputString.length == 3;
    }
}
