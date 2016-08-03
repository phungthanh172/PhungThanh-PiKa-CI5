package controllers;

import models.GameObject;

/**
 * Created by KhacThanh on 8/3/2016.
 */
public interface iColliable {
    GameObject getGameObject();

    void onCollide(iColliable colliable);
}
