package models;

/**
 * Created by KhacThanh on 7/30/2016.
 */
public class Enemy extends Moveable {

    public Enemy(int x, int y) {
        super(x, y);
    }

    public Enemy(int x, int y, int dx, int dy) {
        super(x, y, dx, dy);
    }
}
