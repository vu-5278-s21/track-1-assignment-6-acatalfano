package edu.vanderbilt.cs.live9.expr.state.find;

import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.FindExpression;
import edu.vanderbilt.cs.live9.expr.NearExpression;
import edu.vanderbilt.cs.live9.expr.WhereExpression;
import edu.vanderbilt.cs.live9.expr.state.EndState;

public class FindWhereThenNearClosedState implements FindState {
    @Override
    public void rightParenthesis(QueryVisitor<?> visitor) {
        setChildren(visitor);
        visitor.setState(new EndState(visitor));
    }

    private void setChildren(QueryVisitor<?> visitor) {
        NearExpression nearExpr = (NearExpression)visitor.popTopExpression();
        WhereExpression whereExpr = (WhereExpression)visitor.popTopExpression();
        FindExpression findExpr = (FindExpression)visitor.popTopExpression();
        findExpr.setWhere(whereExpr);
        findExpr.setNear(nearExpr);
    }
}
