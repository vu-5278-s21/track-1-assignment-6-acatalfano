package edu.vanderbilt.cs.live9.expr.state;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.find.FindUninitializedState;

public class InitialState implements State {
    @Override
    public void expressionNode(QueryVisitor<?> visitor) {
        visitor.setState(new FindUninitializedState());
    }
}
