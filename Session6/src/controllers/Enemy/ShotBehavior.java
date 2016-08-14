package controllers.Enemy;

import controllers.Enemy.EnemyController;

/**
 * Created by qhuydtvt on 8/10/2016.
 */
public interface ShotBehavior {
    int BULLET_SPEED = 7;
    int SHOT_PERIOD = 50;
    void doShot(EnemyController enemyController);
}
