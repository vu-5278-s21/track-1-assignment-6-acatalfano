package edu.vanderbilt.cs.live9.expr.state.and;

import edu.vanderbilt.cs.live9.expr.state.ConditionalStateTransition;
import edu.vanderbilt.cs.live9.expr.state.State;

public class AndFirstExprOpenState extends ConditionalStateTransition implements
    AndState
{
    @Override
    protected State queuedStateFactory() {
        return new AndFirstExprClosedState();
    }
}
