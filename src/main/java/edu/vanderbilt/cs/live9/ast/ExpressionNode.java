package edu.vanderbilt.cs.live9.ast;

import java.util.List;

import edu.vanderbilt.cs.live9.expr.Expression;

public class ExpressionNode implements Node {

    private Node leftParen = new LParenNode();

    private LiteralNode operation;

    private List<Node> arguments;

    private Node rightParen = new RParenNode();

    public ExpressionNode(
        LiteralNode operation,
        List<Node> arguments
    ) {
        this.operation = operation;
        this.arguments = arguments;
    }

    public LiteralNode getOperation() {
        return operation;
    }

    public void setOperation(LiteralNode operation) {
        this.operation = operation;
    }

    public List<Node> getArguments() {
        return arguments;
    }

    public void setArguments(List<Node> arguments) {
        this.arguments = arguments;
    }

    public void accept(AstVisitor visitor) {
        visitor.visit(this);
        leftParen.accept(visitor);
        operation.accept(visitor);
        for(Node arg : arguments) {
            arg.accept(visitor);
        }
        rightParen.accept(visitor);
    }
}
