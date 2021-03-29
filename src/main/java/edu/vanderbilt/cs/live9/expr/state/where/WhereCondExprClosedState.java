package edu.vanderbilt.cs.live9.expr.state.where;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.State;

public class WhereCondExprClosedState extends WhereState {
    public WhereCondExprClosedState(State finalDestinationState) {
        super(finalDestinationState);
    }

    @Override
    public void rightParenthesis(QueryVisitor<?> visitor) {
        visitor.setState(finalDestinationState);
    }

}
