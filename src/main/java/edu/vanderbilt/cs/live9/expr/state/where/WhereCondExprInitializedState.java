package edu.vanderbilt.cs.live9.expr.state.where;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.State;

public class WhereCondExprInitializedState extends WhereState {

    protected WhereCondExprInitializedState(State finalDestinationState) {
        super(finalDestinationState);
    }

    @Override
    public void leftParenthesis(QueryVisitor<?> visitor) {
        visitor.setState(new WhereCondExprOpenState(finalDestinationState));
    }
}
