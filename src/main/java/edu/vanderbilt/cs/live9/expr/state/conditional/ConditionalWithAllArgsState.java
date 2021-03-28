package edu.vanderbilt.cs.live9.expr.state.conditional;

import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.State;

public class ConditionalWithAllArgsState extends ConditionalState {
    public ConditionalWithAllArgsState(
        State finalDestinationState,
        ExpressionType operationType
    ) {
        super(finalDestinationState, operationType);
    }

    @Override
    public void rightParenthesis(QueryVisitor<?> visitor) {
        visitor.setState(finalDestinationState);
    }
}
