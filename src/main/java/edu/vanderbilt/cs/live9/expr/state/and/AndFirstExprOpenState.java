package edu.vanderbilt.cs.live9.expr.state.and;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.State;
import edu.vanderbilt.cs.live9.expr.state.conditional.ConditionalInitializedState;

public class AndFirstExprOpenState extends AndState {
    public AndFirstExprOpenState(State finalDestinationState) {
        super(finalDestinationState);
    }

    @Override
    public void literalNode(QueryVisitor<?> visitor, LiteralNode node) {
        ExpressionType type = node.interpret();
        if (type == ExpressionType.AND) {
            visitor
                .setState(
                    new AndInitializedState(
                        new AndFirstExprClosedState(finalDestinationState)
                    )
                );
        } else if (type == ExpressionType.LESS_THAN
            || type == ExpressionType.GREATER_THAN) {
            visitor
                .setState(
                    new ConditionalInitializedState(
                        new AndFirstExprClosedState(finalDestinationState), type
                    )
                );
        } else {
            throw new IllegalStateException("literalNode() called in illegal state");
        }
    }

}
