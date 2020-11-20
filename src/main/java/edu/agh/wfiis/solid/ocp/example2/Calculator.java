//package edu.agh.wfiis.solid.ocp.example2;
import java.util.*;
import java.lang.*;

abstract class Operator 
{
    abstract double calc(double a, double b);
}

public class Calculator 
{
    public HashMap<String, Operator> operators = new HashMap<>();
    
    ///tą funkcją programista może sprawdzić, czy dobrze nazwał klasę do automatycznej rejestracji. Służy także do rozwikłania nazwy klasy operatora
    public static String createOperatorName(String operator)
    {
        if (operator.length() == 1)
            return "Operator" + ((int)operator.charAt(0));
            else
            return "Operator_" + operator;
    }

    ///sprawdza, czy znaleziona klasa jest odpowiedniego typu - jeśli tak, to ją zwraca, jeśli nie, zwraca null
    Operator validateOperator(Object testObject)
    {
        if (testObject != null && (testObject instanceof Operator))
            return (Operator)(testObject);
        return null;
    }
    
    ///funkcja umożliwia dodanie własnych operatorów (jeśli kogoś to interesuje), o ile taki został podany (bo można podać null)
    public void registerOperator(String name, Operator operator)
    {
        if (operator != null)
            operators.putIfAbsent(name, operator);
    }
    
    ///automatyczne szukanie operatorów na podstawie przyjętej w createOperatorName() nomenklarury nazw
    public Operator searchOperator(String operatorName)
    {
        try
        {
            return validateOperator(Class.forName(createOperatorName(operatorName)).newInstance());
        } 
        catch (Exception e) 
        {
            return null;
        }   
    }
     
    ///zwraca operator z zarejestrowanych, jeśli go tam nie ma, to szuka i rejestruje (i go zwraca z zarejestrowanych), jeśli nie może znaleźć, to zwraca null
    public Operator getOperator(String operatorName)
    {
        if (!operators.containsKey(operatorName))        
            registerOperator(operatorName, searchOperator(operatorName));
        return operators.get(operatorName);
    }
     
    //liczy
    public double calculate(double val1, String operator, double val2)
    {
        Operator operatorObject = getOperator(operator);
        if (operatorObject == null) 
            throw new IllegalArgumentException(operator + " is not supported");
            else
            return operatorObject.calc(val1, val2);
    }
     
    ///liczy na podstawie parametrów, o ile to możliwe
    public double calculate(String[] args) 
    {
        if (args.length != 3)
        {
            System.out.println("Too much or not enought parameters");
            return 0;
        }
        return calculate(Double.valueOf(args[0]), args[1], Double.valueOf(args[2]));
    }

    public static void main(String[] args) 
    {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(args));
    }
}

class Addition extends Operator
{
    public double calc(double a, double b)
    {
        return a+b;
    }
}

class Operator43 extends Addition {}    //java Calculator 2 '+' 3
class Operator_plus extends Addition {} //java Calculator 2 plus 3


class Subtraction extends Operator
{
    public double calc(double a, double b)
    {
        return a-b;
    }
}

class Operator45 extends Subtraction {}     //java Calculator 2 '-' 3
class Operator_minus extends Subtraction {} //java Calculator 2 minus 3

class Multiplication extends Operator
{
    public double calc(double a, double b)
    {
        return a*b;
    }
}

class Operator42 extends Multiplication {}      //java Calculator 2 '*' 3
class Operator_times extends Multiplication {}  //java Calculator 2 times 3

class Division extends Operator
{
    public double calc(double a, double b)
    {
        return a/b;
    }
}

class Operator47 extends Division {}        //java Calculator 2 '\' 3
