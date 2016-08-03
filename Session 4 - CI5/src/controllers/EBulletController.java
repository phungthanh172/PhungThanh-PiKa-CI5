package controllers;

import models.EnemyBullet;
import models.GameObject;
import views.ImageDrawer;

/**
 * Created by KhacThanh on 8/3/2016.
 */
public class EBulletController extends SingleController implements iColliable{
    private static final int SPEED = 15;

    public EBulletController(EnemyBullet enemyBullet, ImageDrawer imageDrawer) {
        super(enemyBullet, imageDrawer);
        this.gameVector.dy = SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
//        if (gameObject.getY() < 0 || gameObject.getY() > 800 || gameObject.getX() > 600 || gameObject.getX() < 0) {
//            gameObject.destroy();
//        }

    }

    @Override
    public void onCollide(iColliable colliable) {
//        if(colliable instanceof PlaneController) {
//            System.out.println("BUM BUM");
//        } else {
//            colliable.getGameObject().destroy();
//        }
    }
}
