package edu.vanderbilt.cs.live9.expr.state.and;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.State;

public class AndFirstExprInitializedState extends AndState {
    public AndFirstExprInitializedState(State finalDestinationState) {
        super(finalDestinationState);
    }

    @Override
    public void leftParenthesis(QueryVisitor<?> visitor) {
        visitor.setState(new AndFirstExprOpenState(finalDestinationState));
    }

}
