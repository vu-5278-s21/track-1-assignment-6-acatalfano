package edu.vanderbilt.cs.live9.expr.state.where;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.Expression;
import edu.vanderbilt.cs.live9.expr.WhereExpression;

public class WhereCondExprClosedState implements WhereState {
    @Override
    public void rightParenthesis(QueryVisitor<?> visitor) {
        setChild(visitor);
        visitor.setQueuedState();
    }

    private <T> void setChild(QueryVisitor<?> visitor) {
        Expression<T, Boolean> filterExpr = visitor.popTopExpression();
        WhereExpression<T> whereExpr = (WhereExpression<T>)visitor.peekTopExpression();
        whereExpr.setFilterExpression(filterExpr);
    }
}
