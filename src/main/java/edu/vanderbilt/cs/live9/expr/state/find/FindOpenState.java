package edu.vanderbilt.cs.live9.expr.state.find;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.FindExpression;
import edu.vanderbilt.cs.live9.expr.state.OpenState;

public class FindOpenState implements FindState, OpenState {
    @Override
    public void literalNode(QueryVisitor<?> visitor, LiteralNode node) {
        ExpressionType type = node.interpret();
        if (type == ExpressionType.FIND) {
            findTransition(visitor);
        } else {
            throw new IllegalStateException("literalNode() called in illegal state");
        }
    }

    private void findTransition(QueryVisitor<?> visitor) {
        visitor.storeExpression(new FindExpression<>());
        visitor.setState(new FindInitializedState());
    }
}
