package edu.agh.wfiis.solid.ocp.example2;

public class InputParser {

	public static OperationDataTriplet parse(String[] data){

		if (data.length != 3) 
		{
			throw new IllegalArgumentException("InputParser: Invalid number of input arguments. 3 expected, " + data.length + " received.");
		}

		int val1 = Integer.valueOf(data[0]);
        int val2 = Integer.valueOf(data[2]);
        String operator = data[1];

        return new OperationDataTriplet(val1, operator, val2);
	}
}