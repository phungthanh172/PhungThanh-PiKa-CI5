package controllers;

import models.EnemyBullet;
import models.EnemyPlane;
import views.ImageDrawer;

import java.awt.*;

/**
 * Created by KhacThanh on 8/3/2016.
 */
public class EnemyController extends SingleController implements iColliable{
    EBulletManager eBulletManager;
    public EnemyController(EnemyPlane enemyPlane, ImageDrawer imageDrawer) {
        super(enemyPlane, imageDrawer);
        this.gameVector.dy = 1;
        CollsionPool.instance.add(this);
        eBulletManager = new EBulletManager();

    }
    int cd = 0;
    @Override
    public void run() {
        super.run();
        eBulletManager.run();
//        if(in.nextInt(100) % 11 == 0){
        cd++;
//        if(cd % 20 ==0){
//            EBulletController eBulletController = new EBulletController(
//                        new EnemyBullet(this.getGameObject().middleX() - EnemyBullet.DEFAULT_WIDTH / 2, this.getGameObject().getY() + EnemyBullet.DEFAULT_HEIGHT),
//                        new ImageDrawer("enemy_bullet")
//            );
//
//            eBulletManager.add(eBulletController);
//        }

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        eBulletManager.draw(g);
    }

    @Override
    public void onCollide(iColliable colliable) {
        if(colliable instanceof PlaneController) {
            System.out.println("BUM BUM");
        } else {
            colliable.getGameObject().destroy();
        }
    }
}
