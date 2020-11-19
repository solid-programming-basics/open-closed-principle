package edu.agh.wfiis.solid.ocp.example2;


public class CalculatorInput {
  private int leftOperand;
  private int rightOperand;
  private String operator;

  public CalculatorInput(int leftOperand, int rightOperand, String operator) {
      this.leftOperand = leftOperand;
      this.rightOperand = rightOperand;
      this.operator = operator;
  }

  public int getLeftOperand() {
      return this.leftOperand;
  }

  public int getRightOperand() {
      return this.rightOperand;
  }

  public String getOperator() {
      return this.operator;
  }
}