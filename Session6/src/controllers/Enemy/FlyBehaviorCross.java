package controllers.Enemy;

/**
 * Created by KhacThanh on 8/14/2016.
 */
public class FlyBehaviorCross implements FlyBehavior {
    @Override
    public void doFly(EnemyController enemyController) {
        enemyController.getGameVector().dx = enemyController.SPEED;
        enemyController.getGameVector().dy = enemyController.SPEED;
    }
}
