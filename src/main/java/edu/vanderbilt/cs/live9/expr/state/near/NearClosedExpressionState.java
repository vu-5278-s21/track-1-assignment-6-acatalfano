package edu.vanderbilt.cs.live9.expr.state.near;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.find.FindState;

public class NearClosedExpressionState extends NearState {
    public NearClosedExpressionState(FindState finalDestinationState) {
        super(finalDestinationState);
    }

    @Override
    public void rightParenthesis(QueryVisitor<?> visitor) {
        visitor.setState(finalDesitinationState);
    }
}
