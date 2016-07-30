package models;

/**
 * Created by KhacThanh on 7/30/2016.
 */
public class Moveable {
    public int x;
    public int y;
    public int dx;
    public int dy;

    public Moveable() {
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
    public Moveable(int x, int y) {
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
    }

    public Moveable(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public void MoveTo(int x, int y){
        this.x = x;
        this.y = y;
    }
}
