package models;

/**
 * Created by KhacThanh on 7/27/2016.
 */
public class Plane extends Moveable {

    public Plane(int x, int y) {  
        super(x, y);
    }

    public Plane(int x, int y, int dx, int dy) {
        super(x, y, dx, dy);
    }
}
