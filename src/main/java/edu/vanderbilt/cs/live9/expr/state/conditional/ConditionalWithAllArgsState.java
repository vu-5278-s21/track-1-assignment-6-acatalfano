package edu.vanderbilt.cs.live9.expr.state.conditional;

import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.visitor.QueryVisitor;
import edu.vanderbilt.cs.live9.expr.ConditionalExpression;
import edu.vanderbilt.cs.live9.expr.Expression;

public class ConditionalWithAllArgsState extends ConditionalState {
    public ConditionalWithAllArgsState(ExpressionType operationType) {
        super(operationType);
    }

    @Override
    public void rightParenthesis(QueryVisitor<?> visitor) {
        setChildren(visitor);
        visitor.setQueuedState();
    }

    private void setChildren(QueryVisitor<?> visitor) {
        Expression rightChild = visitor.popTopExpression();
        Expression leftChild = visitor.popTopExpression();
        ConditionalExpression<?> condExpr =
            (ConditionalExpression<?>)visitor.peekTopExpression();
        condExpr.setLeftChild(leftChild);
        condExpr.setRightChild(rightChild);
    }
}
