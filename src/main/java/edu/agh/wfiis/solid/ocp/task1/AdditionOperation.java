package edu.agh.wfiis.solid.ocp.task1;

public class AdditionOperation implements Operation {

    @Override
    public Number doOperation(Number a,Number b)
    {
        if(a instanceof Double || b instanceof Double) {
            return a.doubleValue() + b.doubleValue();
        } else if(a instanceof Float || b instanceof Float) {
            return a.floatValue() + b.floatValue();
        } else if(a instanceof Long || b instanceof Long) {
            return a.longValue() + b.longValue();
        } 
        return a.intValue() + b.intValue();
        
    }

    
}