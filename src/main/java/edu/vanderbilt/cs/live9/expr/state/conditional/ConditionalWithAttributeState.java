package edu.vanderbilt.cs.live9.expr.state.conditional;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.State;

public class ConditionalWithAttributeState extends ConditionalState {

    public ConditionalWithAttributeState(
        State finalDestinationState,
        ExpressionType operationType
    ) {
        super(finalDestinationState, operationType);
    }

    @Override
    public void literalNode(QueryVisitor<?> visitor, LiteralNode node) {
        ExpressionType type = node.interpret();
        if (type == ExpressionType.DOUBLE || type == ExpressionType.INTEGER) {
            visitor
                .setState(new ConditionalWithAllArgsState(finalDestinationState, type));
        } else {
            throw new IllegalStateException("literalNode() called in illegal state");
        }
    }

}
