package at.hul.compoments.strategies;

import at.hul.compoments.interfaces.IMoveStrategy;

public class LeftMoveStrategy implements IMoveStrategy {
    private int x,y;

    public LeftMoveStrategy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(int speed) {
        this.x -= speed;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }


}
