package edu.vanderbilt.cs.live9.expr.state.and;

import edu.vanderbilt.cs.live9.expr.state.State;

public abstract class AndState implements State {
    protected State finalDestinationState;

    protected AndState(State finalDestinationState) {
        this.finalDestinationState = finalDestinationState;
    }
}
