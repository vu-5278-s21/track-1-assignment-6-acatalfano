package edu.vanderbilt.cs.live9.expr.state.and;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;

public class AndSecondExprInitializedState implements AndState {
    @Override
    public void leftParenthesis(QueryVisitor<?> visitor) {
        visitor.setState(new AndSecondExprOpenState());
    }
}
