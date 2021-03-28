package edu.vanderbilt.cs.live9.expr.state.where;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.state.find.FindState;

public class WhereInitializedState extends WhereState {

    public WhereInitializedState(FindState finalDestinationState) {
        super(finalDestinationState);
    }

    @Override
    public void expressionNode(QueryVisitor<?> visitor) {
        visitor.setState(new WhereCondExprInitializedState(finalDestinationState));
    }

}
