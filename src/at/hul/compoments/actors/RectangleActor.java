package at.hul.compoments.actors;

import at.hul.compoments.abstracts.AbstractActor;
import at.hul.compoments.interfaces.IMoveStrategy;
import org.newdawn.slick.Graphics;

public class RectangleActor extends AbstractActor {
    private int width, height;

    public RectangleActor(IMoveStrategy IMoveStrategy, int width, int height) {
        super(IMoveStrategy);
        this.width = width;
        this.height = height;
    }

    @Override
    public void move(int speed) {
        IMoveStrategy.update(speed);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(IMoveStrategy.getX(), IMoveStrategy.getY(), this.width, this.height);
    }

    @Override
    public void setMoveStrategy(IMoveStrategy moveStrategy) {
        this.IMoveStrategy = moveStrategy;
    }

    @Override
    public IMoveStrategy getMoveStrategy() {
        return IMoveStrategy;
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
}
