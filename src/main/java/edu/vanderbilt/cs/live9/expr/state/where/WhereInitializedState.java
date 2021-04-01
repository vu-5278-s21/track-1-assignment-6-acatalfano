package edu.vanderbilt.cs.live9.expr.state.where;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;

public class WhereInitializedState implements WhereState {
    @Override
    public void expressionNode(QueryVisitor<?> visitor) {
        visitor.setState(new WhereCondExprInitializedState());
    }

}
