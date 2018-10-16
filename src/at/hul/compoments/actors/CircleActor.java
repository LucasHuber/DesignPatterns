package at.hul.compoments.actors;

import at.hul.compoments.abstracts.AbstractActor;
import at.hul.compoments.interfaces.IMoveStrategy;
import org.newdawn.slick.Graphics;

public class CircleActor extends AbstractActor {
    private int radius;

    public CircleActor(IMoveStrategy IMoveStrategy, int radius) {
        super(IMoveStrategy);
        this.radius = radius;
    }

    @Override
    public void move(int speed) {
        IMoveStrategy.update(speed);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(IMoveStrategy.getX(), IMoveStrategy.getY(), this.radius, this.radius);
    }

    @Override
    public void setMoveStrategy(IMoveStrategy moveStrategy) {
        this.IMoveStrategy = moveStrategy;
    }

    @Override
    public IMoveStrategy getMoveStrategy() {
        return this.IMoveStrategy;
    }

}
