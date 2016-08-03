package controllers;

import models.Bullet;
import models.EnemyBullet;
import models.EnemyPlane;
import views.ImageDrawer;

import java.awt.*;
import java.util.Iterator;
import java.util.Random;


/**
 * Created by KhacThanh on 8/3/2016.
 */
public class EnemyManager extends ControllerManager {
//
//    private static final int DISTANCE = 120 ;
//    private static final int COUNT_DOWN = 500;
//    int cd;
//    public EnemyManager() {
//        super();
//
//        int enX = 10;
//        int enY = 10;
//        for (int i = 0; i < 5; i++) {
//            EnemyController enemyController = new EnemyController(
//                    new EnemyPlane(enX, enY),
//                    new ImageDrawer("enemy_plane_yellow_1")
//            );
//            enX += DISTANCE;
//            this.add(enemyController);
//
//        }
//    }
//
//    @Override
//    public void run() {
//        super.run();
//        cd++;
//        if (cd % COUNT_DOWN == 0) {
//            int enX = 10;
//            int enY = 10;
//            for (int i = 0; i < 5; i++) {
//                EnemyController enemyController = new EnemyController(
//                        new EnemyPlane(enX, enY),
//                        new ImageDrawer("enemy_plane_yellow_1")
//                );
//                enX += DISTANCE;
//                this.add(enemyController);
//                CollsionPool.instance.add(enemyController);
//            }
//
//        }
////        if(cd % (COUNT_DOWN / 5 ) == 0) {
////            for (SingleController singleController:
////            this.singleControllerVector ) {
////                EBulletController eBulletController = new EBulletController(
////                        new EnemyBullet(singleController.getGameObject().middleX() - EnemyBullet.DEFAULT_WIDTH / 2, singleController.getGameObject().getY() + EnemyBullet.DEFAULT_HEIGHT),
////                        new ImageDrawer("enemy_bullet")
////                );
////                EBulletManager.instance.add(eBulletController);
////                CollsionPool.instance.add(eBulletController);
////            }
////        }
//    }
//    public final static EnemyManager instance = new EnemyManager();
//}
private ControllerManager enemyControllerManager;
    private ControllerManager bulletOfEnemyControllerManager;
    private SingleController singleController;
    private int enX;
    private int enY;
    public EnemyManager() {
        super();
        enemyControllerManager = new ControllerManager();
        bulletOfEnemyControllerManager = new ControllerManager();

        Thread EnemyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1500);
                        enX = new Random().nextInt(500);
                        EnemyController enemyController = new EnemyController(
                                new EnemyPlane(enX ,0),
                                new ImageDrawer("enemy_plane_yellow_1")
                        );
                        enemyControllerManager.add(enemyController);
                        //CollsionPool.instance.add(enemyController);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread bulletOfEnemy = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        Thread.sleep(1000);
//                        Iterator<SingleController> enemyControllerIterator = enemyControllerManager.singleControllerVector.iterator();
//                        while(enemyControllerIterator.hasNext()){
//                            singleController = enemyControllerIterator.next();
//                            EBulletController bulletEnemyController = new EBulletController(
//                                    new EnemyBullet(singleController.gameObject.getX() ,singleController.gameObject.getY() + 50),
//                                    new ImageDrawer("enemy_bullet")
//                            );
//                            bulletOfEnemyControllerManager.add(bulletEnemyController);
//                            //CollsionPool.instance.add(bulletEnemyController);
//                        }
                        for (int i = 0; i < enemyControllerManager.singleControllerVector.size(); i++) {
                            singleController = enemyControllerManager.singleControllerVector.get(i);
                            EBulletController bulletEnemyController = new EBulletController(
                                    new EnemyBullet(singleController.gameObject.getX() ,singleController.gameObject.getY() + 50),
                                    new ImageDrawer("enemy_bullet")
                            );
                            bulletOfEnemyControllerManager.add(bulletEnemyController);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        EnemyThread.start();
        bulletOfEnemy.start();

    }
    public void run(){
        enemyControllerManager.run();
        bulletOfEnemyControllerManager.run();
    }
    public void draw(Graphics g) {
        enemyControllerManager.draw(g);
        bulletOfEnemyControllerManager.draw(g);
    }
}
