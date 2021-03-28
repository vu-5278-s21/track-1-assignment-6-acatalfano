package edu.vanderbilt.cs.live9.expr.state.where;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.OpenState;
import edu.vanderbilt.cs.live9.expr.state.State;
import edu.vanderbilt.cs.live9.expr.state.and.AndInitializedState;
import edu.vanderbilt.cs.live9.expr.state.conditional.ConditionalInitializedState;

public class WhereCondExprOpenState extends WhereState implements OpenState {
    protected WhereCondExprOpenState(State finalDestinationState) {
        super(finalDestinationState);
    }

    @Override
    public void literalNode(QueryVisitor<?> visitor, LiteralNode node) {
        ExpressionType type = node.interpret();
        if (type == ExpressionType.AND) {
            visitor.setState(new AndInitializedState(finalDestinationState));
        } else if (type == ExpressionType.GREATER_THAN
            || type == ExpressionType.LESS_THAN
        ) {
            visitor
                .setState(new ConditionalInitializedState(finalDestinationState, type));
        } else {
            throw new IllegalStateException("literalNode() called in illegal state");
        }
    }

}
