package at.hul.main;

import at.hul.compoments.actors.CircleActor;
import at.hul.compoments.actors.RectangleActor;
import at.hul.compoments.actors.ShapeActor;
import at.hul.compoments.actors.SingletonScore;
import at.hul.compoments.interfaces.Actor;
import at.hul.compoments.interfaces.Observable;
import at.hul.compoments.interfaces.Observer;
import at.hul.compoments.strategies.DownMoveStrategy;
import at.hul.compoments.strategies.LeftMoveStrategy;
import at.hul.compoments.strategies.RightMoveStrategy;
import at.hul.compoments.strategies.UpMoveStrategy;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.Random;


public class Starter extends BasicGame implements Observable {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private CircleActor circleActor;
    private RectangleActor rectangleActor;
    private ArrayList<Actor> actors = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<>();

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
        actors.forEach(actor -> actor.render(graphics));

    }

    @Override
    public void keyPressed(int key, char c) {
        super.keyPressed(key, c);

        if (key == Input.KEY_SPACE){
            this.informAll();
        }
    }

    //------------------------------------------------------------------------------------------

    private void initActors() {
        this.circleActor = new CircleActor(new DownMoveStrategy(300,100),50);
        this.rectangleActor = new RectangleActor(new RightMoveStrategy(50,50),50,50);
        actors.add(this.rectangleActor);
        actors.add(this.circleActor);
        observers.add(this.rectangleActor);
        observers.add(this.circleActor);

        for(int i = 0; i < 20; i++){
            actors.add(new ShapeActor(new RightMoveStrategy(100 + new Random().nextInt(500), 100 + new Random().nextInt(400)), 100, 50, ShapeActor.generateRandomShape()));
        }
    }

    private void incrementScoreAndShow(){
        SingletonScore.getInstance().incrementScore();
        System.out.println(SingletonScore.getInstance().showScore());
    }

    private void CircleActorLogic() {
        if (this.circleActor.getMoveStrategy().getY() > HEIGHT) {
            this.circleActor.setMoveStrategy(new UpMoveStrategy(this.circleActor.getMoveStrategy().getX(),this.circleActor.getMoveStrategy().getY()));
        } else if (this.circleActor.getMoveStrategy().getY() < 0 ){
            this.circleActor.setMoveStrategy(new DownMoveStrategy(this.circleActor.getMoveStrategy().getX(), this.circleActor.getMoveStrategy().getY()));
        }
    }

    private void moveActors() {
        actors.forEach(actor -> actor.move(2));
    }

    private void RectangleActorLogic() {
        if (this.rectangleActor.getMoveStrategy().getX() > WIDTH - 100) {
            this.rectangleActor.setMoveStrategy(new DownMoveStrategy(this.rectangleActor.getMoveStrategy().getX(), this.rectangleActor.getMoveStrategy().getY()));
            this.rectangleActor.getMoveStrategy().setX(700);
            this.incrementScoreAndShow();
        } else if (this.rectangleActor.getMoveStrategy().getY() > HEIGHT - 100) {
            this.rectangleActor.setMoveStrategy(new LeftMoveStrategy(this.rectangleActor.getMoveStrategy().getX(), this.rectangleActor.getMoveStrategy().getY()));
            this.rectangleActor.getMoveStrategy().setY(500);
            this.incrementScoreAndShow();
        } else if (this.rectangleActor.getMoveStrategy().getX() < 50) {
            this.rectangleActor.setMoveStrategy(new UpMoveStrategy(this.rectangleActor.getMoveStrategy().getX(), this.rectangleActor.getMoveStrategy().getY()));
            this.rectangleActor.getMoveStrategy().setX(50);
            this.incrementScoreAndShow();
        } else if (this.rectangleActor.getMoveStrategy().getY() < 50) {
            this.rectangleActor.setMoveStrategy(new RightMoveStrategy(this.rectangleActor.getMoveStrategy().getX(), this.rectangleActor.getMoveStrategy().getY()));
            this.rectangleActor.getMoveStrategy().setY(50);
            this.incrementScoreAndShow();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void informAll() {
        observers.forEach(observer -> observer.inform());
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