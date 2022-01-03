
interface CalculatoringDesignPattern{
    int Calculate(int ValOne, int ValTwo);
}

class AddNumbers implements CalculatoringDesignPattern{

    int Calculate(int ValOne, int ValTwo){
        System.out.println(ValOne + ValTwo);
        return ValOne + ValTwo;
    }

}

class SubtractNumbers implements CalculatoringDesignPattern{

    int Calculate(int ValOne, int ValTwo){
        System.out.println(ValOne - ValTwo);
        return ValOne - ValTwo;
    }

}

class MultiplyNumbers implements CalculatoringDesignPattern{

    int Calculate(int ValOne, int ValTwo){
        System.out.println(ValOne * ValTwo);
        return ValOne * ValTwo;
    }

}


public class Calculator{

    private Map<char, CalculatoringDesignPattern> TypesOfCalculations;

    TypesOfCalculations.put("+", AddNumbers);
    TypesOfCalculations.put("-", SubtractNumbers);
    TypesOfCalculations.put("*", MultiplyNumbers);

    int Calculate(int ValOne, int ValTwo, char operator){
        return this.TypesOfCalculations.get(operator).Calculate(ValOne, ValTwo);
    }

}
