package controllers;

import models.EnemyBullet;
import views.ImageDrawer;

/**
 * Created by KhacThanh on 8/3/2016.
 */
public class EBulletManager extends ControllerManager {
    private static final int COUNT_DOWN = 50;
    private int cd = 0;

    public EBulletManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
//        if(cd % (COUNT_DOWN ) == 0) {
//            System.out.println("TEST");
//            for (SingleController singleController:
//                    EnemyManager.instance.singleControllerVector ) {
//                EBulletController eBulletController = new EBulletController(
//                        new EnemyBullet(singleController.getGameObject().middleX() - EnemyBullet.DEFAULT_WIDTH / 2, singleController.getGameObject().getY() + EnemyBullet.DEFAULT_HEIGHT),
//                        new ImageDrawer("enemy_bullet")
//                );
//                System.out.println("ADDED");
//                this.add(eBulletController);
//                CollsionPool.instance.add(eBulletController);
//            }
//        }
//        cd++;
    }

    public final static EnemyManager instance = new EnemyManager();

}
