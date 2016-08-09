package controllers;

import models.GameObject;
import views.GameDrawer;

/**
 * Created by KhacThanh on 8/9/2016.
 */
public class GiftController2 extends SingleController implements Colliable {

    public GiftController2(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.getGameVector().dy = 5;
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            this.getGameObject().destroy();
            System.out.println("AN GIFT NO TOAN MAN HINH");
            EnemyControllerManager.instance.destroyAllEnemyInScreen();
        }
    }
}
