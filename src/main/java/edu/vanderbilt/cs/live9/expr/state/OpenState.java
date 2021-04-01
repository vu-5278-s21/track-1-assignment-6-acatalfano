package edu.vanderbilt.cs.live9.expr.state;

import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;

public interface OpenState extends State {
    @Override
    public abstract void literalNode(QueryVisitor<?> visitor, LiteralNode node);
}
