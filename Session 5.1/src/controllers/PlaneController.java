package controllers;
import models.Bullet;
import models.Plane;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by qhuydtvt on 7/30/2016.
 */
public class PlaneController extends SingleController
        implements KeyListener, Colliable {

    public static final int SPEED = 10;
    public static final int ATK_SPEED = 3;
    private int count;


    private ControllerManager bulletManager;
    private GameInput gameInput;


    private PlaneController(Plane plane, GameDrawer gameDrawer) {
        super(plane, gameDrawer);
        this.bulletManager = new ControllerManager();
        this.gameInput = new GameInput();
        CollsionPool.instance.add(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
//                this.gameVector.dy = -SPEED;
                this.gameInput.keyUp = true;
                break;
            case KeyEvent.VK_DOWN:
//                this.gameVector.dy = SPEED;
                this.gameInput.keyDown = true;
                break;
            case KeyEvent.VK_LEFT:
                //this.gameVector.dx = -SPEED;
                this.gameInput.keyLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
//                this.gameVector.dx = SPEED;
                this.gameInput.keyRight = true;
                break;
            case KeyEvent.VK_SPACE:
                this.gameInput.keySpace = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
//                this.gameVector.dy = -SPEED;
                this.gameInput.keyUp = false;
                break;
            case KeyEvent.VK_DOWN:
//                this.gameVector.dy = SPEED;
                this.gameInput.keyDown = false;
                break;
            case KeyEvent.VK_LEFT:
                //this.gameVector.dx = -SPEED;
                this.gameInput.keyLeft = false;
                break;
            case KeyEvent.VK_RIGHT:
//                this.gameVector.dx = SPEED;
                this.gameInput.keyRight = false;
                break;
            case KeyEvent.VK_SPACE:
                this.gameInput.keySpace = false;
//                BulletController bulletController = new BulletController(
//                        new Bullet(this.gameObject.getMiddleX() - Bullet.WIDTH / 2, this.gameObject.getY()),
//                        new ImageDrawer("resources/bullet.png")
//                );
//                bulletManager.add(bulletController);
                break;
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletManager.draw(g);
    }

    @Override
    public void run() {
        count++;
        this.gameVector.dx = 0;
        this.gameVector.dy = 0;

        if(gameInput.keyDown && !gameInput.keyUp) {
            this.gameVector.dy = SPEED;
        } else if(!gameInput.keyDown && gameInput.keyUp) {
            this.gameVector.dy = -SPEED;
        }

        if(gameInput.keyLeft && !gameInput.keyRight) {
            this.gameVector.dx = -SPEED;
        } else if(!gameInput.keyLeft && gameInput.keyRight) {
            this.gameVector.dx = SPEED;
        }

        if (gameInput.keySpace) {
            if(count > ATK_SPEED) {
                BulletController bulletController = new BulletController(
                        new Bullet(this.gameObject.getMiddleX() - Bullet.WIDTH / 2, this.gameObject.getY()),
                        new ImageDrawer("resources/bullet.png")
                );
                bulletManager.add(bulletController);
                count = 0;
            }
        }

        super.run();
        bulletManager.run();

    }

    public final static PlaneController instance = new PlaneController(
            new Plane(250, 600),
            new ImageDrawer("resources/plane3.png")
    );

    @Override
    public void onCollide(Colliable colliable) {

    }
}
