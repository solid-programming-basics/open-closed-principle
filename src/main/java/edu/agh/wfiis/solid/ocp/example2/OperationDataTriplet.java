package edu.agh.wfiis.solid.ocp.example2;

public class OperationDataTriplet {
	private int firstVal;
	private int secondVal;
	private String operator;


	OperationDataTriplet(int firstVal, String operator, int secondVal){
		this.firstVal = firstVal;
		this.operator = operator;
		this.secondVal = secondVal;
	}


	public int getFirstVal() {
		return firstVal;
	}

	public int getSecondVal() {
		return secondVal;
	}

	public String getOperator() {
		return operator;
	}

}