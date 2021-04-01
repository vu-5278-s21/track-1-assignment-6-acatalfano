package edu.vanderbilt.cs.live9.expr.state.conditional;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.AttributeValueExpression;
import edu.vanderbilt.cs.live9.expr.NumberExpression;
import edu.vanderbilt.cs.live9.expr.state.State;

public abstract class ConditionalArgStateTransition extends ConditionalState {
    protected ConditionalArgStateTransition(ExpressionType operationType) {
        super(operationType);
    }

    protected abstract State nextStateFactory();

    @Override
    public final void literalNode(QueryVisitor<?> visitor, LiteralNode node) {
        ExpressionType type = node.interpret();
        switch (type) {
            case INTEGER:
            case DOUBLE:
                numberTransition(visitor, node);
                break;

            case ATTRIBUTE:
                attributeValueTransition(visitor, node);
                break;

            default:
                throw new IllegalStateException("literalNode() called in illegal state");
        }
    }

    private void numberTransition(QueryVisitor<?> visitor, LiteralNode node) {
        visitor
            .storeExpression(new NumberExpression<>(Double.parseDouble(node.getValue())));
        visitor.setState(nextStateFactory());
    }

    private void attributeValueTransition(QueryVisitor<?> visitor, LiteralNode node) {
        visitor
            .storeExpression(new AttributeValueExpression(node.getValue().substring(1)));
        visitor.setState(nextStateFactory());
    }

}
