package edu.vanderbilt.cs.live9.ast;

import edu.vanderbilt.cs.live9.expr.Expression;

public class RParenNode implements Node {
    @Override
    public void accept(AstVisitor visitor) {
        visitor.visit(this);
    }
}
