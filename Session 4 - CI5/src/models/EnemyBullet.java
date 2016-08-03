package models;

/**
 * Created by KhacThanh on 8/3/2016.
 */
public class EnemyBullet extends GameObject{
    public static final int DEFAULT_WIDTH = 32;
    public static final int DEFAULT_HEIGHT = 32;
    public static final int DEFAULT_HP = 10;

    public EnemyBullet(int x, int y, int width, int height, int hp) {
        super(x, y, width, height, hp);
    }
    public EnemyBullet(int x, int y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_HP);
    }
}
