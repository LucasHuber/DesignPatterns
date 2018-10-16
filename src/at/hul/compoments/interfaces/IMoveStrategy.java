package at.hul.compoments.interfaces;

public interface IMoveStrategy {
    void update(int speed);
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
}
