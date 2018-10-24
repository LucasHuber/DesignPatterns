package at.hul.compoments.actors;

import at.hul.compoments.abstracts.AbstractActor;
import at.hul.compoments.interfaces.MoveStrategy;
import at.hul.compoments.interfaces.Observer;
import at.hul.compoments.strategies.UpMoveStrategy;
import org.newdawn.slick.Graphics;

public class CircleActor extends AbstractActor implements Observer {
    private int radius;

    public CircleActor(MoveStrategy MoveStrategy, int radius) {
        super(MoveStrategy);
        this.radius = radius;
    }

    @Override
    public void move(int speed) {
        this.MoveStrategy.update(speed);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.MoveStrategy.getX(), this.MoveStrategy.getY(), this.radius, this.radius);
    }

    @Override
    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.MoveStrategy = moveStrategy;
    }

    @Override
    public MoveStrategy getMoveStrategy() {
        return this.MoveStrategy;
    }

    @Override
    public void inform() {
        this.setMoveStrategy(new UpMoveStrategy(this.MoveStrategy.getX(), this.MoveStrategy.getY()));
    }
}
