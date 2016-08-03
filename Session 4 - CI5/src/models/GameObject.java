package models;

import java.awt.*;

/**
 * Created by KhacThanh on 8/3/2016.
 */
public class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected  int hp;

    protected boolean isAlive;


    //CONSTRUCTOR

    public GameObject(int x, int y, int width, int height, int hp) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.hp = hp;
        this.isAlive = true;
    }

    // GETTER & SETTER
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    //MENTHOD
    public void move(GameVector gameVector) {
        x += gameVector.dx;
        y += gameVector.dy;
    }
    public int middleX() {
        return this.x + this.width / 2;
    }
    public boolean overlap(Rectangle rect) {
        return this.getRect().intersects(rect);
    }

    public boolean overlap(GameObject gameObject) {
        return overlap(gameObject.getRect());
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public void destroy() {
        isAlive = false;
    }
}
