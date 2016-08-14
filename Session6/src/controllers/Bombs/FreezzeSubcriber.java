package controllers.Bombs;

import models.GameObject;

/**
 * Created by qhuydtvt on 8/10/2016.
 */
public interface FreezzeSubcriber {
    void onFrezze(int x, int y);
    GameObject getGameObject();
}
