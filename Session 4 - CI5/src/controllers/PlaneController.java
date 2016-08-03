package controllers;

import models.Bullet;
import models.GameObject;
import models.Plane;
import untils.Untils;
import views.ImageDrawer;
import views.iGameDrawer;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by KhacThanh on 8/3/2016.
 */
public class PlaneController extends SingleController implements KeyListener, iColliable {
    private static final int SPEED = 5;
    private static final int COUNT_DOWN = 10;
    private ControllerManager bulletManager;
    private Set<Integer> keyEventSet = new TreeSet<>();
    private int bulletCD = 0;

    private PlaneController(Plane plane, ImageDrawer imageDrawer) {
        super(plane, imageDrawer);
        bulletManager = new ControllerManager();

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keyEventSet.add(keyEvent.getKeyCode());
        //System.out.println(keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keyEventSet.remove(keyEvent.getKeyCode());
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletManager.draw(g);
        bulletManager.run();
    }

    @Override
    public void run() {
        if (gameObject.getY() < 40) {
            gameObject.setY(40);
        }
        if (gameObject.getY() > 720) {
            gameObject.setY(720);
        }
        if (gameObject.getX() > 520) {
            gameObject.setX(520);
        }
        if (gameObject.getX() < 10) {
            gameObject.setX(10);
        }
        super.run();
        changemove();

    }

    public void changemove() {
        bulletCD ++;
        int x = 0;
        int y = 0;
        if (keyEventSet.contains(KeyEvent.VK_DOWN)) {
            y += SPEED;
        }
        if (keyEventSet.contains(KeyEvent.VK_UP)) {
            y -= SPEED;
        }
        if (keyEventSet.contains(KeyEvent.VK_RIGHT)) {
            x += SPEED;
        }
        if (keyEventSet.contains(KeyEvent.VK_LEFT)) {
            x -= SPEED;
        }
        this.gameVector.dy = y;
        this.gameVector.dx = x;
        if (bulletCD % COUNT_DOWN == 0) {
            if (keyEventSet.contains(KeyEvent.VK_SPACE)) {
                BulletController bulletController = new BulletController(
                        new Bullet(this.getGameObject().middleX() - Bullet.DEFAULT_WIDTH / 2, this.getGameObject().getY() - Bullet.DEFAULT_HEIGHT ),
                        new ImageDrawer("bullet")
                );
                bulletManager.add(bulletController);
            }
//            for (Integer i: keyEventSet
//                    ) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
        }

    }

    private static PlaneController planeController;

    public static PlaneController getPlaneController() {
        if (planeController == null) {
            planeController = new PlaneController(new Plane(250, 600),
                    new ImageDrawer("plane2"));
            CollsionPool.instance.add(planeController);
        }

        return planeController;
    }

    @Override
    public void onCollide(iColliable colliable) {
//        if (colliable instanceof BulletController) {
            colliable.getGameObject().destroy();

            if (this.getGameObject().getHp() > 0) {
                this.getGameObject().setHp(this.getGameObject().getHp() - 10);
            } else {
                System.out.println("GAME OVER");
                System.exit(0);
            }
//        } else if(colliable instanceof EnemyController) {
//            colliable.getGameObject().destroy();
//        }
    }
}
