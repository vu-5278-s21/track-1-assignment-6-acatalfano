package edu.vanderbilt.cs.live9.expr.state.find;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;

public class FindWithClosedNearClauseState implements FindState {
    @Override
    public void expressionNode(QueryVisitor<?> visitor) {
        visitor.setState(new FindNearSecondExprInitializedState());
    }
}
