package models;

/**
 * Created by KhacThanh on 8/3/2016.
 */
public class Bullet extends GameObject {
    public static final int DEFAULT_WIDTH = 12;
    public static final int DEFAULT_HEIGHT = 32;
    private static final int DEFAULT_HP = 1;

    public Bullet(int x, int y, int width, int height, int hp) {
        super(x, y, width, height, hp);
    }

    public Bullet(int x, int y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_HP);
    }
}
