package at.hul.compoments.actors;

import at.hul.compoments.abstracts.AbstractActor;
import at.hul.compoments.interfaces.MoveStrategy;
import org.newdawn.slick.Graphics;

import java.util.Random;


public class ShapeActor extends AbstractActor {
    private int width, height;
    private int shapeNumber;

    public ShapeActor(MoveStrategy MoveStrategy, int width, int height, int shapeNumber) {
        super(MoveStrategy);
        this.width = width;
        this.height = height;
        this.shapeNumber = shapeNumber;
    }

    public static int generateRandomShape(){
        Random random = new Random();
        int randomNumber = random.nextInt(4);

        return randomNumber;
    }

    @Override
    public void move(int speed) {
        this.MoveStrategy.update(speed);
    }

    @Override
    public void render(Graphics graphics) {
        switch (shapeNumber){
            case 0:
                graphics.drawRect(this.MoveStrategy.getX(), this.MoveStrategy.getY(), this.width, this.height);
                break;
            case 1:
                graphics.drawOval(this.MoveStrategy.getX(), this.MoveStrategy.getY(), this.width, this.width);
                break;
            case 2:
                graphics.drawRect(this.MoveStrategy.getX(), this.MoveStrategy.getY(), this.width, this.width);
                break;
            case 3:
                graphics.drawOval(this.MoveStrategy.getX(), this.MoveStrategy.getY(), this.width, this.height);
                break;
            default: return;
        }
    }

    @Override
    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.MoveStrategy = moveStrategy;
    }

    @Override
    public MoveStrategy getMoveStrategy() {
        return this.getMoveStrategy();
    }
}
