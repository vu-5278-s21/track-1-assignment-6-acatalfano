package edu.vanderbilt.cs.live9.expr;

public class GreaterThanExpression<T> extends ConditionalExpression<T> {
    @Override
    public Boolean evaluate(Context<T> ctx) {
        Number lhs = (Number)leftChild.evaluate(ctx);
        Number rhs = (Number)rightChild.evaluate(ctx);

        return lhs.doubleValue() > rhs.doubleValue();
    }
}
