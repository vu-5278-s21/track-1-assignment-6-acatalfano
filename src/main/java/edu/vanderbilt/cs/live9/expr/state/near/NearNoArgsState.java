package edu.vanderbilt.cs.live9.expr.state.near;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.State;
import edu.vanderbilt.cs.live9.expr.state.find.FindState;

public class NearNoArgsState extends NearState {
    public NearNoArgsState(FindState finalDestinationState) {
        super(finalDestinationState);
    }

    @Override
    public void literalNode(QueryVisitor<?> visitor, LiteralNode node) {
        ExpressionType type = node.interpret();
        if (type == ExpressionType.DOUBLE) {
            visitor.setState(new NearOneArgState(finalDesitinationState));
        } else {
            throw new IllegalStateException("literalNode() called in illegal state");
        }
    }
}
