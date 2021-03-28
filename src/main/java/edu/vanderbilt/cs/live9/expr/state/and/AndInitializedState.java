package edu.vanderbilt.cs.live9.expr.state.and;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.State;

public class AndInitializedState extends AndState {
    public AndInitializedState(State finalDestinationState) {
        super(finalDestinationState);
    }

    @Override
    public void expressionNode(QueryVisitor<?> visitor) {
        visitor.setState(new AndFirstExprInitializedState(finalDestinationState));
    }

}
