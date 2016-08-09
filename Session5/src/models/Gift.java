package models;

/**
 * Created by KhacThanh on 8/9/2016.
 */
public class Gift extends GameObject {

    private static final int DEFAULT_WIDTH = 30;
    private static final int DEFAULT_HEIGHT= 30;

    public Gift(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public Gift(int x, int y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

}
