package edu.vanderbilt.cs.live9.expr.state.conditional;

import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.expr.state.State;

public abstract class ConditionalState implements State {
    protected final ExpressionType operationType;

    protected ConditionalState(ExpressionType operationType) {
        this.operationType = operationType;
    }
}
