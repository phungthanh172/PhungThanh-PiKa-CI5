//package controllers.Enemy;
//
//import controllers.Colliable;
//import controllers.EnemyBulletController;
//import controllers.Enemy.EnemyBulletControllerManager;
//import controllers.PlaneController;
//import models.Enemy;
//import models.EnemyBullet;
//import views.GameDrawer;
//import views.ImageDrawer;
//
//import java.awt.*;
//
///**
// * Created by qhuydtvt on 8/3/2016.
// */
//public class EnemyController2 extends EnemyController implements Colliable {
//
//    private final static int MOVEMENT_SPEED = 1;
//    private final static int SHOT_SPEED = 150;
//    private final static int BULLET_SPEED = 3;
//    private int count;
//
//    public EnemyController2(Enemy gameObject, GameDrawer gameDrawer) {
//        super(gameObject, gameDrawer);
//
//        this.gameVector.dx = MOVEMENT_SPEED;
//        this.gameVector.dy = MOVEMENT_SPEED;
//    }
//    @Override
//    public void run() {
//        super.run();
//        count ++;
//        if (count == SHOT_SPEED) {
//            EnemyBulletController enemyBulletController =
//                    new EnemyBulletController(
//                            new EnemyBullet( this.gameObject.getMiddleX() - EnemyBullet.SIZE / 2, this.gameObject.getBottom()),
//                            new ImageDrawer("resources/enemy_bullet.png")
//                );
//            int dx = PlaneController.instance.getGameObject().getX() - gameObject.getX();
//            int dy = PlaneController.instance.getGameObject().getY() - gameObject.getY();
//
//            if (dy > 0) {
//                double ratio = Math.sqrt(dx * dx + dy * dy) / BULLET_SPEED;
//
//                enemyBulletController.getGameVector().dy = (int)(dy / ratio);
//                enemyBulletController.getGameVector().dx = (int)(dx / ratio);
//
//                EnemyBulletControllerManager.instance.add(enemyBulletController);
//            }
//        }
//
//        if(this.gameObject.getX() >= 600 || this.gameObject.getX() <= 0) {
//            this.gameVector.dx = -this.gameVector.dx;
//        }
//    }
//
//    @Override
//    public void draw(Graphics g) {
//        super.draw(g);
//    }
//
//    @Override
//    public void onCollide(Colliable colliable) {
//
//    }
//}
