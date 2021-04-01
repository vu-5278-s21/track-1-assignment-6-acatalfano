package edu.vanderbilt.cs.live9.expr.state.near;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;

public class NearTwoArgsState implements NearState {
    @Override
    public void literalNode(QueryVisitor<?> visitor, LiteralNode node) {
        ExpressionType type = node.interpret();
        if (type == ExpressionType.INTEGER) {
            createNumberExpression(visitor, node);
            visitor.setState(new NearAllArgsState());
        } else {
            throw new IllegalStateException("literalNode() called in illegal state");
        }
    }
}
