package edu.vanderbilt.cs.live9.expr;

public abstract class ConditionalExpression<T> implements
    CompositeExpression<T, Boolean>
{
    protected Expression leftChild;
    protected Expression rightChild;

    public Expression getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Expression leftChild) {
        this.leftChild = leftChild;
    }

    public Expression getRightChild() {
        return rightChild;
    }

    public void setRightChild(Expression rightChild) {
        this.rightChild = rightChild;
    }
}
