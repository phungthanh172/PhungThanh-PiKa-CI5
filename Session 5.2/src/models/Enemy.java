package models;

/**
 * Created by qhuydtvt on 7/30/2016.
 */
public class Enemy extends GameObjectWithHP {

    public static final int DEFAULT_WIDTH = 45;
    public static final int DEFAULT_HEIGHT = 30;

    public Enemy(int x, int y, int width, int height) {
        this(x, y, width, height, 1);
    }

    public Enemy(int x, int y, int width, int height, int maxHP) {
        super(x, y, width, height, maxHP);
    }

    public Enemy(int x, int y, int maxHP) {
        this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, maxHP);
    }

    public Enemy(int x, int y) {
        this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
