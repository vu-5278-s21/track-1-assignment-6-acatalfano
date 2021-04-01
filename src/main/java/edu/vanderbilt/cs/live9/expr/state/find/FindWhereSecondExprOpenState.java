package edu.vanderbilt.cs.live9.expr.state.find;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.NearExpression;
import edu.vanderbilt.cs.live9.expr.state.near.NearNoArgsState;

public class FindWhereSecondExprOpenState implements FindState {
    @Override
    public void literalNode(QueryVisitor<?> visitor, LiteralNode node) {
        ExpressionType type = node.interpret();
        if (type == ExpressionType.NEAR) {
            nearTransition(visitor);
        } else {
            throw new IllegalStateException("literalNode() called in illegal state");
        }
    }

    private void nearTransition(QueryVisitor<?> visitor) {
        visitor.storeExpression(new NearExpression<>());
        visitor.queueState(new FindWhereThenNearClosedState());
        visitor.setState(new NearNoArgsState());
    }
}
