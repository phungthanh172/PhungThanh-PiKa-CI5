package models;

/**
 * Created by KhacThanh on 8/3/2016.
 */
public class Plane extends GameObject{
    private static final int DEFAULT_WIDTH = 70;
    private static final int DEFAULT_HEIGHT = 56;
    private static final int DEFAULT_HP = 100;

    public Plane(int x, int y, int width, int height, int hp) {
        super(x, y, width, height, hp);
    }
    //    public void move(Direction direction) {
//        switch (direction){
//            case UP:
//                y -= SPEED;
//                break;
//            case DOWN:
//                y += SPEED;
//                break;
//            case LEFT:
//                x -= SPEED;
//                break;
//            case RIGHT:
//                x += SPEED;
//                break;
//
//        }
//    }

    public Plane(int x, int y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_HP);
    }

}
