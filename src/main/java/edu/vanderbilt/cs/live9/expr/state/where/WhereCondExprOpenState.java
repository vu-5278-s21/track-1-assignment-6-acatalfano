package edu.vanderbilt.cs.live9.expr.state.where;

import edu.vanderbilt.cs.live9.expr.state.ConditionalStateTransition;
import edu.vanderbilt.cs.live9.expr.state.OpenState;
import edu.vanderbilt.cs.live9.expr.state.State;

public class WhereCondExprOpenState extends ConditionalStateTransition implements
    WhereState,
    OpenState
{
    @Override
    protected State queuedStateFactory() {
        return new WhereCondExprClosedState();
    }
}
