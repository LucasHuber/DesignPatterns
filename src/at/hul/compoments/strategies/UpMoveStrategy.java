package at.hul.compoments.strategies;

import at.hul.compoments.interfaces.MoveStrategy;

public class UpMoveStrategy implements MoveStrategy {
    private int x,y;

    public UpMoveStrategy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(int speed) {
        this.y -= speed;
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
