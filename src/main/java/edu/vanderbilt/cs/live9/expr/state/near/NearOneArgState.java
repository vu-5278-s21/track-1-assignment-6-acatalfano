package edu.vanderbilt.cs.live9.expr.state.near;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.find.FindState;

public class NearOneArgState extends NearState {
    public NearOneArgState(FindState finalDestinationState) {
        super(finalDestinationState);
    }

    @Override
    public void literalNode(QueryVisitor<?> visitor, LiteralNode node) {
        ExpressionType type = node.interpret();
        if (type == ExpressionType.DOUBLE || type == ExpressionType.INTEGER) {
            visitor.setState(new NearTwoArgsState(finalDesitinationState));
        } else {
            throw new IllegalStateException("literalNode() called in illegal state");
        }
    }
}
