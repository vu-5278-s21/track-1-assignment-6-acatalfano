package edu.vanderbilt.cs.live9.expr.state.and;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.State;

public class AndSecondExprClosedState extends AndState {
    public AndSecondExprClosedState(State finalDestinationState) {
        super(finalDestinationState);
    }

    @Override
    public void rightParenthesis(QueryVisitor<?> visitor) {
        visitor.setState(finalDestinationState);
    }
}
