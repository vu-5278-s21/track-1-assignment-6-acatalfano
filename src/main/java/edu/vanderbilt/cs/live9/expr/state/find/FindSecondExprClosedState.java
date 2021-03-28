package edu.vanderbilt.cs.live9.expr.state.find;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.EndState;

public class FindSecondExprClosedState implements FindState {
    @Override
    public void rightParenthesis(QueryVisitor<?> visitor) {
        visitor.setState(new EndState());
    }
}
