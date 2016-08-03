package controllers;

import models.GameObject;
import models.GameVector;
import views.ImageDrawer;
import views.iGameDrawer;

import java.awt.*;

/**
 * Created by KhacThanh on 8/3/2016.
 */
public class SingleController implements iBaseController {
    protected GameObject gameObject;
    private ImageDrawer imageDrawer;
    public GameVector gameVector;

    public SingleController(GameObject gameObject, ImageDrawer imageDrawer) {
        this.gameObject = gameObject;
        this.imageDrawer = imageDrawer;
        this.gameVector = new GameVector();
    }

    public GameObject getGameObject() {
        return this.gameObject;
    }

    @Override
    public void draw(Graphics g) {
        imageDrawer.draw(g, gameObject);
    }

    @Override
    public void run() {
        gameObject.move(this.gameVector);
    }
}
