package edu.vanderbilt.cs.live9.expr.state.conditional;

import edu.vanderbilt.cs.live9.ast.interpreter.ExpressionType;
import edu.vanderbilt.cs.live9.expr.state.State;

public class ConditionalWithOneArgState extends ConditionalArgStateTransition {

    public ConditionalWithOneArgState(ExpressionType operationType) {
        super(operationType);
    }

    @Override
    protected State nextStateFactory() {
        return new ConditionalWithAllArgsState(operationType);
    }
}
