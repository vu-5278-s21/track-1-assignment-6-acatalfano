package edu.vanderbilt.cs.live9.expr.state.and;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.State;

public class AndFirstExprClosedState extends AndState {
    public AndFirstExprClosedState(State finalDestinationState) {
        super(finalDestinationState);
    }

    @Override
    public void expressionNode(QueryVisitor<?> visitor) {
        visitor.setState(new AndSecondExprInitializedState(finalDestinationState));
    }

}
