package models;

/**
 * Created by qhuydtvt on 7/27/2016.
 */
public class Bullet extends GameObject {

    public final static int WIDTH = 13;
    public final static int HEIGHT = 30;

    private int damage;

    public Bullet(int x, int y) {
        this(x, y, 2);
    }

    public Bullet(int x, int y, int damage) {
        super(x, y, WIDTH, HEIGHT);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
