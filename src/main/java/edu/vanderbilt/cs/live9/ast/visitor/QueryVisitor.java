package edu.vanderbilt.cs.live9.ast.visitor;

import java.util.Stack;
import java.util.stream.Stream;

import edu.vanderbilt.cs.live6.DataAndPosition;
import edu.vanderbilt.cs.live9.ast.AstVisitor;
import edu.vanderbilt.cs.live9.ast.ExpressionNode;
import edu.vanderbilt.cs.live9.ast.LParenNode;
import edu.vanderbilt.cs.live9.ast.LiteralNode;
import edu.vanderbilt.cs.live9.ast.RParenNode;
import edu.vanderbilt.cs.live9.expr.Expression;
import edu.vanderbilt.cs.live9.expr.state.EndState;
import edu.vanderbilt.cs.live9.expr.state.InitialState;
import edu.vanderbilt.cs.live9.expr.state.State;

public class QueryVisitor<T> implements AstVisitor {

    private Expression<T, Stream<DataAndPosition<T>>> root;
    private State state = new InitialState();
    private Stack<State> queuedStates = new Stack<>();
    private Stack<Expression<?, ?>> expressions = new Stack<>();

    public void setRoot() {
        root = popTopExpression();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void queueState(State state) {
        queuedStates.push(state);
    }

    public void setQueuedState() {
        state = queuedStates.empty() ? null : queuedStates.pop();
    }

    public void storeExpression(Expression<?, ?> expression) {
        expressions.push(expression);
    }

    public Expression<?, ?> peekTopExpression() {
        return expressions.empty() ? null : expressions.peek();
    }

    public <U, V> Expression<U, V> popTopExpression() {
        return expressions.empty() ? null : (Expression<U, V>)expressions.pop();
    }

    public Expression<T, Stream<DataAndPosition<T>>> getRoot() {
        boolean validTree = (this.state instanceof EndState);
        return validTree ? root : null;
    }

    @Override
    public void visit(ExpressionNode n) {
        state.expressionNode(this);
    }

    @Override
    public void visit(LiteralNode l) {
        state.literalNode(this, l);
    }

    @Override
    public void visit(LParenNode l) {
        state.leftParenthesis(this);
    }

    @Override
    public void visit(RParenNode r) {
        state.rightParenthesis(this);
    }

}
