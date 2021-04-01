package edu.vanderbilt.cs.live9.expr.state.and;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;

public class AndInitializedState implements AndState {
    @Override
    public void expressionNode(QueryVisitor<?> visitor) {
        visitor.setState(new AndFirstExprInitializedState());
    }

}
