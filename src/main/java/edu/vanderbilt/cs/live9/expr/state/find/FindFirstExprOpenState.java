package edu.vanderbilt.cs.live9.expr.state.find;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.NearExpression;
import edu.vanderbilt.cs.live9.expr.WhereExpression;
import edu.vanderbilt.cs.live9.expr.state.OpenState;
import edu.vanderbilt.cs.live9.expr.state.near.NearNoArgsState;
import edu.vanderbilt.cs.live9.expr.state.where.WhereInitializedState;

public class FindFirstExprOpenState implements FindState, OpenState {

    @Override
    public void literalNode(QueryVisitor<?> visitor, LiteralNode node) {
        ExpressionType type = node.interpret();
        if (type == ExpressionType.WHERE) {
            whereTransition(visitor);
        } else if (type == ExpressionType.NEAR) {
            nearTransition(visitor);
        } else {
            throw new IllegalStateException("literalNode() called in illegal state");
        }
    }

    private void whereTransition(QueryVisitor<?> visitor) {
        visitor.storeExpression(new WhereExpression<>());
        visitor.queueState(new FindWithClosedWhereClauseState());
        visitor.setState(new WhereInitializedState());
    }

    private void nearTransition(QueryVisitor<?> visitor) {
        visitor.storeExpression(new NearExpression<>());
        visitor.queueState(new FindWithClosedNearClauseState());
        visitor.setState(new NearNoArgsState());
    }
}
