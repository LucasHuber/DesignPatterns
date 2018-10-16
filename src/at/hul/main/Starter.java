package at.hul.main;

import at.hul.compoments.actors.CircleActor;
import at.hul.compoments.actors.RectangleActor;
import at.hul.compoments.interfaces.IActor;
import at.hul.compoments.interfaces.IMoveStrategy;
import at.hul.compoments.strategies.DownMoveStrategy;
import at.hul.compoments.strategies.LeftMoveStrategy;
import at.hul.compoments.strategies.RightMoveStrategy;
import at.hul.compoments.strategies.UpMoveStrategy;
import org.newdawn.slick.*;



public class Starter extends BasicGame{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private IActor circleActor, rectangleActor;

    public Starter() {
        super("DesignPatterns");

    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        initActors();

    }

    @Override
    public void update(GameContainer gameContainer, int millisSinceLastCall) throws SlickException {
        CircleActorLogic();
        RectangleActorLogic();
        moveActors();

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        renderActors(graphics);

    }

    //------------------------------------------------------------------------------------------

    private void initActors() {
        this.circleActor = new CircleActor(new DownMoveStrategy(300,100),50);
        this.rectangleActor = new RectangleActor(new RightMoveStrategy(50,50),50,50);
    }

    private void CircleActorLogic() {
        if (this.circleActor.getMoveStrategy().getY() > HEIGHT) {
            this.circleActor.setMoveStrategy(new UpMoveStrategy(this.circleActor.getMoveStrategy().getX(),this.circleActor.getMoveStrategy().getY()));
        } else if (this.circleActor.getMoveStrategy().getY() < 0 ){
            this.circleActor.setMoveStrategy(new DownMoveStrategy(this.circleActor.getMoveStrategy().getX(), this.circleActor.getMoveStrategy().getY()));
        }
    }

    private void moveActors() {
        this.circleActor.move(1);
        this.rectangleActor.move(4);
    }

    private void RectangleActorLogic() {
        if (this.rectangleActor.getMoveStrategy().getX() > 700) {
            this.rectangleActor.setMoveStrategy(new DownMoveStrategy(this.rectangleActor.getMoveStrategy().getX(), this.rectangleActor.getMoveStrategy().getY()));
            this.rectangleActor.getMoveStrategy().setX(700);
        } else if (this.rectangleActor.getMoveStrategy().getY() > 500) {
            this.rectangleActor.setMoveStrategy(new LeftMoveStrategy(this.rectangleActor.getMoveStrategy().getX(), this.rectangleActor.getMoveStrategy().getY()));
            this.rectangleActor.getMoveStrategy().setY(500);
        } else if (this.rectangleActor.getMoveStrategy().getX() < 50) {
            this.rectangleActor.setMoveStrategy(new UpMoveStrategy(this.rectangleActor.getMoveStrategy().getX(), this.rectangleActor.getMoveStrategy().getY()));
            this.rectangleActor.getMoveStrategy().setX(50);
        } else if (this.rectangleActor.getMoveStrategy().getY() < 50) {
            this.rectangleActor.setMoveStrategy(new RightMoveStrategy(this.rectangleActor.getMoveStrategy().getX(), this.rectangleActor.getMoveStrategy().getY()));
            this.rectangleActor.getMoveStrategy().setY(50);
        }
    }

    private void renderActors(Graphics graphics) {
        this.circleActor.render(graphics);
        this.rectangleActor.render(graphics);
    }

    //------------------------------------------------------------------------------------------

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Starter());
            container.setDisplayMode(WIDTH, HEIGHT,false);
            container.setTargetFrameRate(60);
            container.start();
        } catch (SlickException var2) {
            var2.printStackTrace();
        }
    }
}