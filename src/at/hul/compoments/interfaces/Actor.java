package at.hul.compoments.interfaces;

import org.newdawn.slick.Graphics;

public interface Actor {
    void move(int speed);
    void render(Graphics graphics);
    void setMoveStrategy (MoveStrategy moveStrategy);
    MoveStrategy getMoveStrategy ();
}
