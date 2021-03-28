package edu.vanderbilt.cs.live9.expr.state.find;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.UninitializedState;

public class FindFirstExprUninitializedState implements
    FindState,
    UninitializedState
{

    @Override
    public void leftParenthesis(QueryVisitor<?> visitor) {
        visitor.setState(new FindFirstExprOpenState());
    }

}
