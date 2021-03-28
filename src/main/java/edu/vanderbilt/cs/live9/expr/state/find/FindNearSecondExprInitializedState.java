package edu.vanderbilt.cs.live9.expr.state.find;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;

public class FindNearSecondExprInitializedState implements FindState {
    @Override
    public void leftParenthesis(QueryVisitor<?> visitor) {
        visitor.setState(new FindNearSecondExprOpenState());
    }
}
