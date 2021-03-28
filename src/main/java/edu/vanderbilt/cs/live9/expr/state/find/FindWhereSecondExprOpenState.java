package edu.vanderbilt.cs.live9.expr.state.find;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.near.NearNoArgsState;

public class FindWhereSecondExprOpenState implements FindState {
    @Override
    public void literalNode(QueryVisitor<?> visitor, LiteralNode node) {
        ExpressionType type = node.interpret();
        if (type == ExpressionType.NEAR) {
            visitor.setState(new NearNoArgsState(new FindSecondExprClosedState()));
        } else {
            throw new IllegalStateException("literalNode() called in illegal state");
        }
    }
}
