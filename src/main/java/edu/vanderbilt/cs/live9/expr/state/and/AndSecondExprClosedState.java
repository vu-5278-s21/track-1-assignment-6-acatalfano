package edu.vanderbilt.cs.live9.expr.state.and;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.AndExpression;
import edu.vanderbilt.cs.live9.expr.Expression;

public class AndSecondExprClosedState implements AndState {
    @Override
    public void rightParenthesis(QueryVisitor<?> visitor) {
        setChildren(visitor);
        visitor.setQueuedState();
    }

    private <T> void setChildren(QueryVisitor<?> visitor) {
        Expression<T, Boolean> rightChild = visitor.popTopExpression();
        Expression<T, Boolean> leftChild = visitor.popTopExpression();
        AndExpression<T> andExpr = (AndExpression<T>)visitor.peekTopExpression();
        andExpr.setLeftChild(leftChild);
        andExpr.setRightChild(rightChild);
    }
}
