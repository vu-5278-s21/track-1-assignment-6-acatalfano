package edu.vanderbilt.cs.live9.ast;

import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.ast.interpreter.SymbolMapper;

public class LiteralNode implements Node {

    private SymbolMapper symbolMapper = new SymbolMapper();
    private String value;

    public LiteralNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void accept(AstVisitor visitor) {
        visitor.visit(this);
    }

    public ExpressionType interpret() {
        return symbolMapper.getType(this);
    }
}
