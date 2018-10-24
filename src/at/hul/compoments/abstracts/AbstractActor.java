package at.hul.compoments.abstracts;

import at.hul.compoments.interfaces.Actor;
import at.hul.compoments.interfaces.MoveStrategy;

public abstract class AbstractActor implements Actor {
    protected MoveStrategy MoveStrategy;
    public AbstractActor(MoveStrategy MoveStrategy) {
        this.MoveStrategy = MoveStrategy;
    }

}
