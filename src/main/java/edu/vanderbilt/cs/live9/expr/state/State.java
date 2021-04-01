package edu.vanderbilt.cs.live9.expr.state;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;

public interface State {
    default void expressionNode(QueryVisitor<?> visitor) {
        throw new IllegalStateException("expressionNode() called in illegal state");
    }

    default void leftParenthesis(QueryVisitor<?> visitor) {
        throw new IllegalStateException("leftParenthesis() called in illegal state");
    }

    default void rightParenthesis(QueryVisitor<?> visitor) {
        throw new IllegalStateException("rightParenthesis() called in illegal state");
    }

    default void literalNode(QueryVisitor<?> visitor, LiteralNode node) {
        throw new IllegalStateException("literalNode() called in illegal state");
    }
}
