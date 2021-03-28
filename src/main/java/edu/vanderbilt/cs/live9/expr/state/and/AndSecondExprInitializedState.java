package edu.vanderbilt.cs.live9.expr.state.and;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.State;

public class AndSecondExprInitializedState extends AndState {
    public AndSecondExprInitializedState(State finalDestinationState) {
        super(finalDestinationState);
    }

    @Override
    public void leftParenthesis(QueryVisitor<?> visitor) {
        visitor.setState(new AndSecondExprOpenState(finalDestinationState));
    }
}
