package edu.vanderbilt.cs.live9.expr.state.near;

import edu.vanderbilt.cs.live9.expr.state.State;
import edu.vanderbilt.cs.live9.expr.state.find.FindState;

public abstract class NearState implements State {
    protected final FindState finalDesitinationState;

    protected NearState(FindState finalDestinationState) {
        this.finalDesitinationState = finalDestinationState;
    }
}
