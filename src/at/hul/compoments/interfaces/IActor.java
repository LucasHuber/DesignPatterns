package at.hul.compoments.interfaces;

import org.newdawn.slick.Graphics;

public interface IActor {
    void move(int speed);
    void render(Graphics graphics);
    void setMoveStrategy (IMoveStrategy moveStrategy);
    IMoveStrategy getMoveStrategy ();
}
