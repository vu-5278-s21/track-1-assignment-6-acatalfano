package edu.vanderbilt.cs.live9.expr.state.where;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;

public class WhereCondExprInitializedState implements WhereState {
    @Override
    public void leftParenthesis(QueryVisitor<?> visitor) {
        visitor.setState(new WhereCondExprOpenState());
    }
}
