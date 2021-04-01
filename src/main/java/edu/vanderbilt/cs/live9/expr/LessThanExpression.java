package edu.vanderbilt.cs.live9.expr;

public class LessThanExpression<T> extends ConditionalExpression<T> {
    @Override
    public Boolean evaluate(Context<T> ctx) {
        Double lhs = (Double)leftChild.evaluate(ctx);
        Double rhs = (Double)rightChild.evaluate(ctx);

        return lhs < rhs;
    }
}
