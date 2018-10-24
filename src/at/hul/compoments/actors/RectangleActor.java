package at.hul.compoments.actors;

import at.hul.compoments.abstracts.AbstractActor;
import at.hul.compoments.interfaces.MoveStrategy;
import at.hul.compoments.interfaces.Observer;
import at.hul.compoments.strategies.RightMoveStrategy;
import org.newdawn.slick.Graphics;

public class RectangleActor extends AbstractActor implements Observer {
    private int width, height;

    public RectangleActor(MoveStrategy MoveStrategy, int width, int height) {
        super(MoveStrategy);
        this.width = width;
        this.height = height;
    }

    @Override
    public void move(int speed) {
        MoveStrategy.update(speed);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(MoveStrategy.getX(), MoveStrategy.getY(), this.width, this.height);
    }

    @Override
    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.MoveStrategy = moveStrategy;
    }

    @Override
    public MoveStrategy getMoveStrategy() {
        return MoveStrategy;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void inform() {
        this.setMoveStrategy(new RightMoveStrategy(this.MoveStrategy.getX(), this.MoveStrategy.getY()));
    }
}
