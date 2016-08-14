package controllers;

import models.GameObject;
import views.GameDrawer;

/**
 * Created by qhuydtvt on 8/3/2016.
 */
class EnemyBulletController extends SingleController implements Colliable {

    public EnemyBulletController(
            GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            this.getGameObject().destroy();
        }
    }
}
