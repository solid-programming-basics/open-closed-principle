package edu.agh.wfiis.solid.ocp.example2;

import java.util.Set;


public class CalculatorInputParser {
  private Set<String> supportedOperators;

  public CalculatorInputParser(Set<String> supportedOperators) {
      this.supportedOperators = supportedOperators;
  }

  public CalculatorInput parse(String[] args) {
      if (args.length != 3) {
          throw new IllegalArgumentException("Too" + ( args.length > 3 ? " many ": " few ") + "arguments, exactly 3 required!");
      }

      String operator = args[1];
      if (!isReceivedOperatorSupported(operator)) {
          throw new IllegalArgumentException("Operator " + operator + " is not supported!");
      }

      int leftOperand = Integer.parseInt(args[0]);
      int rightOperand = Integer.parseInt(args[2]);

      return new CalculatorInput(leftOperand, rightOperand, operator);
  }

  private boolean isReceivedOperatorSupported(String operator) {
      return this.supportedOperators.contains(operator);
  }
}