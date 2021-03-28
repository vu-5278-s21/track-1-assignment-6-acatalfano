package edu.vanderbilt.cs.live9.expr;

import edu.vanderbilt.cs.live7.AttributesStrategy;
import edu.vanderbilt.cs.live7.ProximityStreamDB;

public class Context<T> {

    private Object target;

    private ProximityStreamDB<T> db;

    private AttributesStrategy<?> attributesStrategy;

    // @ToDo, WhereExpression.java calls this and casts to Stream<DataAndPosition<T>>
    //      while AttributeValueExpression.java calls this and casts to DataAndPosition (raw type)
    // ... probably need to change "target" into w/e it needs to be (maybe 2 things)
    // ... or change implementations of the Expressions
    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public ProximityStreamDB<T> getDb() {
        return db;
    }

    public void setDb(ProximityStreamDB<T> db) {
        this.db = db;
    }

    public AttributesStrategy<?> getAttributesStrategy() {
        return attributesStrategy;
    }

    public void setAttributesStrategy(AttributesStrategy<?> attributesStrategy) {
        this.attributesStrategy = attributesStrategy;
    }
}
