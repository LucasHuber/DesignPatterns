package at.hul.main;

import at.hul.compoments.actors.CircleActor;
import at.hul.compoments.interfaces.IActor;
import at.hul.compoments.interfaces.IMoveStrategy;
import at.hul.compoments.strategies.DownMoveStrategy;
import at.hul.compoments.strategies.LeftMoveStrategy;
import at.hul.compoments.strategies.UpMoveStrategy;
import org.newdawn.slick.*;



public class Starter extends BasicGame{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private IActor circleActor;

    public Starter() {
        super("DesignPatterns");

    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.circleActor = new CircleActor(new DownMoveStrategy(300,100),50);

    }
    @Override
    public void update(GameContainer gameContainer, int millisSinceLastCall) throws SlickException {
        CircleActorLogic();
        this.circleActor.move(1);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        this.circleActor.render(graphics);
    }

    //------------------------------------------------------------------------------------------

    private void CircleActorLogic() {
        if (this.circleActor.getMoveStrategy().getY() > HEIGHT) {
            this.circleActor.setMoveStrategy(new UpMoveStrategy(this.circleActor.getMoveStrategy().getX(),this.circleActor.getMoveStrategy().getY()));
        } else if (this.circleActor.getMoveStrategy().getY() < 0 ){
            this.circleActor.setMoveStrategy(new DownMoveStrategy(this.circleActor.getMoveStrategy().getX(), this.circleActor.getMoveStrategy().getY()));
        }
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