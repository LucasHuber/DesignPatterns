package at.hul.compoments.actors;

public class SingletonScore {
    private static SingletonScore instance = null;

    private int score;

    public SingletonScore(){
        score = 0;
    }

    public static SingletonScore getInstance(){
        if (instance == null){
            instance = new SingletonScore();
        }
        return instance;
    }

    public void incrementScore(){
        this.score++;
    }

    public void decrementScore(){
        this.score--;
    }

    public int showScore(){
        return this.score;
    }
}
