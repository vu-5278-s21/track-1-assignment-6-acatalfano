package edu.vanderbilt.cs.live9.ast.visitor;

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

    public void setState(State state) {
        this.state = state;
    }

    public Expression<T, Stream<DataAndPosition<T>>> getRoot() {
        boolean validTree = (this.state instanceof EndState);
        return validTree ? root : null;
    }

    @Override
    public void visit(ExpressionNode n) {
        System.out
            .println("Visit expression node: \"" + n.getOperation().getValue() + "\"");
        state.expressionNode(this);
        // Expression<?, ?> expression = n.build();
        // root = (Expression<T, Stream<DataAndPosition<T>>>)expression;
    }

    @Override
    public void visit(LiteralNode l) {
        System.out.println("Visit literal node: \"" + l.getValue() + "\"");
        state.literalNode(this, l);
        // Expression<?, ?> literalExpression = l.build();
    }

    @Override
    public void visit(LParenNode l) {
        System.out.println("Visit left-paren node");
        state.leftParenthesis(this);
        // @ToDo kill this vvv
        // LParenNode other = (l == null) ? null : l;
        // return;
        //throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void visit(RParenNode r) {
        System.out.println("Visit right-paren node");
        state.rightParenthesis(this);
        // @ToDo kill this vvv
        // RParenNode other = (r == null) ? null : r;
        // return;
        //throw new UnsupportedOperationException("Not implemented");
    }

}
