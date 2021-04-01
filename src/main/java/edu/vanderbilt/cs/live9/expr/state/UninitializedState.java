package edu.vanderbilt.cs.live9.expr.state;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;

public interface UninitializedState extends State {

    @Override
    public abstract void leftParenthesis(QueryVisitor<?> visitor);
}
