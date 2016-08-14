package controllers.Enemy;

import models.EnemyBullet;
import models.GameObject;
import views.ImageDrawer;

/**
 * Created by KhacThanh on 8/13/2016.
 */
public class ShotBehaviorStraight implements ShotBehavior {
    private int count;
    @Override
    public void doShot(EnemyController enemyController) {
        count++;
        if (count >= SHOT_PERIOD) {
            count = 0;
            GameObject gameObject = enemyController.getGameObject();
            EnemyBulletController enemyBulletController = new EnemyBulletController(
                    new EnemyBullet(
                            gameObject.getMiddleX() - EnemyBullet.SIZE / 2,
                            gameObject.getBottom()),
                    new ImageDrawer("resources/enemy_bullet.png")
            );
            enemyBulletController.getGameVector().dy = BULLET_SPEED;
            EnemyBulletControllerManager.instance.add(enemyBulletController);
        }
    }
}
