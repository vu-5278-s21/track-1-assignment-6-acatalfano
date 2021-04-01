package edu.vanderbilt.cs.live9.expr.state.find;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.WhereExpression;
import edu.vanderbilt.cs.live9.expr.state.where.WhereInitializedState;

public class FindNearSecondExprOpenState implements FindState {
    @Override
    public void literalNode(QueryVisitor<?> visitor, LiteralNode node) {
        ExpressionType type = node.interpret();
        if (type == ExpressionType.WHERE) {
            whereTransition(visitor);
        } else {
            throw new IllegalStateException("literalNode() called in illegal state");
        }
    }

    private void whereTransition(QueryVisitor<?> visitor) {
        visitor.storeExpression(new WhereExpression<>());
        visitor.queueState(new FindNearThenWhereClosedState());
        visitor.setState(new WhereInitializedState());
    }
}
