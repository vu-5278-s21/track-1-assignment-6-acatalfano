package edu.vanderbilt.cs.live9.expr.state.where;

import edu.vanderbilt.cs.live9.expr.state.State;

public abstract class WhereState implements State {
    protected final State finalDestinationState;

    protected WhereState(State finalDestinationState) {
        this.finalDestinationState = finalDestinationState;
    }
}
