package controllers.Enemy;

/**
 * Created by KhacThanh on 8/14/2016.
 */
public class FlyBehaviorZicZac implements FlyBehavior {
    private int count;

    public FlyBehaviorZicZac() {

    }

    @Override
    public void doFly(EnemyController enemyController) {
        count++;
        if(count == 1 ) {
            enemyController.getGameVector().dx = enemyController.SPEED;
            enemyController.getGameVector().dy = enemyController.SPEED;

        }
        if (enemyController.getGameObject().getX() >=600 || enemyController.getGameObject().getX() <= 0){
        enemyController.getGameVector().dx = -enemyController.getGameVector().dx;
    }
    }
}
