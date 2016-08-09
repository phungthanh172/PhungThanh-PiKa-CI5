package controllers;

import models.Enemy;
import views.ImageDrawer;

import java.util.Iterator;

/**
 * Created by qhuydtvt on 7/31/2016.
 */
public class EnemyControllerManager extends ControllerManager {

    private int count;
    private static final int RESPAWN_TYPE1 = 100;
    private static final int RESPAWN_TYPE2 = 200;


    private EnemyControllerManager() {
        super();


    }

    @Override
    public void run() {
        super.run();

        count++;

        int enX = 10;
        int enY = 10;

        if (count == RESPAWN_TYPE2) {
            count = 0;
            /* TODO: Generate plane controller 2 */
            for (int i = 0; i < 5; i++) {
                EnemyController2 enemyController = new EnemyController2(
                        new Enemy(enX, enY, 2),
                        new ImageDrawer("resources/enemy_plane_white_3.png")
                );
                enX += 100;
                this.add(enemyController);
            }
        } else if (count == RESPAWN_TYPE1) {
            for (int i = 0; i < 5; i++) {
                EnemyController1 enemyController1 = new EnemyController1(
                        new Enemy(enX, enY),
                        new ImageDrawer("resources/plane1.png")
                );
                enX += 100;
                this.add(enemyController1);
            }
        }
    }

    public void destroyAllEnemyInScreen() {
        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator =
                    this.singleControllerVector.iterator();
            while (singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                singleController.getGameObject().destroy();
                //Destroy all
            }
        }
    }

    public void destroyAllEnemyWithRadius(int radius , int giftX, int giftY) {

        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator =
                    this.singleControllerVector.iterator();
            while (singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                if (singleController.getGameObject().getX() > giftX - radius &&
                        singleController.getGameObject().getX() < giftX + radius &&
                        singleController.getGameObject().getY() > giftY - radius &&
                        singleController.getGameObject().getY() < giftY + radius
                        ) {
                    singleController.getGameObject().destroy();
                    //destroy with radius
                }
            }
        }
    }

    public final static EnemyControllerManager instance = new EnemyControllerManager();
}
