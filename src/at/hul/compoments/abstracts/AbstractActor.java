package at.hul.compoments.abstracts;

import at.hul.compoments.interfaces.IActor;
import at.hul.compoments.interfaces.IMoveStrategy;

public abstract class AbstractActor implements IActor {
    protected IMoveStrategy IMoveStrategy;

    public AbstractActor(IMoveStrategy IMoveStrategy) {
        this.IMoveStrategy = IMoveStrategy;
    }

}
