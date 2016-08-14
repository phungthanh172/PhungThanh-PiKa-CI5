package controllers.Enemy;

import controllers.Bombs.FreezzeSubcriber;

/**
 * Created by qhuydtvt on 8/10/2016.
 */
public class FreezeBehavior {
    private int count;
    private int frezzePeriod;

    public FreezeBehavior(int frezzePeriod) {
        this.frezzePeriod = frezzePeriod;
        this.count = 0;
    }

    public void run(EnemyController enemyController) {
        switch (enemyController.getEnemyState()) {
            case NORMAL:
                break;
            case FREZZED:
                count++;
                if(count > frezzePeriod) {
                    count = 0;
                    enemyController.setEnemyState(EnemyState.NORMAL);
                }
                break;
        }
    }
}
