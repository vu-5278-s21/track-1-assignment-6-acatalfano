package edu.vanderbilt.cs.live9.expr.state.near;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.Expression;
import edu.vanderbilt.cs.live9.expr.NearExpression;

public class NearAllArgsState implements NearState {
    @Override
    public void rightParenthesis(QueryVisitor<?> visitor) {
        setChildren(visitor);
        visitor.setQueuedState();
    }

    private <T> void setChildren(QueryVisitor<?> visitor) {
        Expression<T, Double> rightChild = visitor.popTopExpression();
        Expression<T, Double> middleChild = visitor.popTopExpression();
        Expression<T, Double> leftChild = visitor.popTopExpression();
        NearExpression<T> nearExpr = (NearExpression<T>)visitor.peekTopExpression();
        nearExpr.setLeftChild(leftChild);
        nearExpr.setMiddleChild(middleChild);
        nearExpr.setRightChild(rightChild);
    }
}
