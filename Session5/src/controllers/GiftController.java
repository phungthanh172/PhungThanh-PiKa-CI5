package controllers;

import models.GameObject;
import views.GameDrawer;

/**
 * Created by KhacThanh on 8/9/2016.
 */
public class GiftController  extends SingleController implements Colliable  {
    private int radius;
    private static final int DEFAULT_RADIUS = 300;
    public GiftController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        radius = DEFAULT_RADIUS;
        this.getGameVector().dy = 5;
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            this.getGameObject().destroy();
            System.out.println("AN GIFT NO");
            EnemyControllerManager.instance.destroyAllEnemyWithRadius(this.radius, this.getGameObject().getX(), this.getGameObject().getY());
        }
    }

    public int getRadius() {
        return radius;
    }
}
