package models;

/**
 * Created by KhacThanh on 7/27/2016.
 */
public class Bullet extends Moveable {
    public boolean flip;

    public Bullet(int x, int y, boolean flip) {

        super.x = x;
        super.y = y;
        super.dx = 0;
        if (flip)
            super.dy = -5;
        else super.dy = 5;
    }

    public Bullet(int x, int y, int dx, int dy, boolean flip) {
        super(x, y, dx, dy);
        this.flip = flip;
    }
}