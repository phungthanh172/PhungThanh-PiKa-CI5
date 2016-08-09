package controllers;

import models.Enemy;
import views.GameDrawer;

/**
 * Created by qhuydtvt on 7/31/2016.
 */
public class EnemyController1 extends
        SingleController implements Colliable {

    public static final int SPEED = 3;

    public EnemyController1(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);

        this.gameVector.dy = SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
