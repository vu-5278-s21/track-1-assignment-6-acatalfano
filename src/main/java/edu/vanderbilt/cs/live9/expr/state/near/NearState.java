package edu.vanderbilt.cs.live9.expr.state.near;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.NumberExpression;
import edu.vanderbilt.cs.live9.expr.state.State;

public interface NearState extends State {
    default void createNumberExpression(QueryVisitor<?> visitor, LiteralNode node) {
        double value = Double.parseDouble(node.getValue());
        visitor.storeExpression(new NumberExpression<>(value));
    }
}
