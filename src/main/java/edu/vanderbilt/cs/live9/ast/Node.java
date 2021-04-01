package edu.vanderbilt.cs.live9.ast;

public interface Node {

    void accept(AstVisitor visitor);

}
