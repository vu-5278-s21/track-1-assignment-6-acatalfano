package edu.vanderbilt.cs.live9.expr.state;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;

public class EndState implements State {
    public EndState(QueryVisitor<?> visitor) {
        visitor.setRoot();
    }
}
