package edu.vanderbilt.cs.live9.expr.state;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.AndExpression;
import edu.vanderbilt.cs.live9.expr.GreaterThanExpression;
import edu.vanderbilt.cs.live9.expr.LessThanExpression;
import edu.vanderbilt.cs.live9.expr.state.and.AndInitializedState;
import edu.vanderbilt.cs.live9.expr.state.conditional.ConditionalInitializedState;

public abstract class ConditionalStateTransition implements State {
    protected abstract State queuedStateFactory();

    @Override
    public final void literalNode(QueryVisitor<?> visitor, LiteralNode node) {
        ExpressionType type = node.interpret();
        visitor.queueState(queuedStateFactory());
        switch (type) {
            case LESS_THAN:
            case GREATER_THAN:
                createConditionalExpression(visitor, type);
                visitor.setState(new ConditionalInitializedState(type));
                break;

            case AND:
                createAndExpression(visitor);
                visitor.setState(new AndInitializedState());
                break;

            default:
                throw new IllegalStateException("literalNode() called in illegal state");
        }
    }

    private void createConditionalExpression(
        QueryVisitor<?> visitor,
        ExpressionType type
    ) {
        if (type == ExpressionType.LESS_THAN) {
            visitor.storeExpression(new LessThanExpression<>());
        } else if (type == ExpressionType.GREATER_THAN) {
            visitor.storeExpression(new GreaterThanExpression<>());
        }
    }

    private void createAndExpression(QueryVisitor<?> visitor) {
        visitor.storeExpression(new AndExpression<>());
    }
}
