package edu.vanderbilt.cs.live9.expr.state.find;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.OpenState;
import edu.vanderbilt.cs.live9.expr.state.near.NearNoArgsState;
import edu.vanderbilt.cs.live9.expr.state.where.WhereInitializedState;

public class FindFirstExprOpenState implements FindState, OpenState {

    @Override
    public void literalNode(QueryVisitor<?> visitor, LiteralNode node) {
        ExpressionType type = node.interpret();
        if (type == ExpressionType.WHERE) {
            visitor
                .setState(
                    new WhereInitializedState(new FindWithClosedWhereClauseState())
                );
        } else if (type == ExpressionType.NEAR) {
            visitor
                .setState(
                    new NearNoArgsState(new FindWithClosedNearClauseState())
                );
        } else {
            throw new IllegalStateException("literalNode() called in illegal state");
        }
    }
}
