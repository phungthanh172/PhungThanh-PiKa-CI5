package controllers;

import models.GameObject;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by KhacThanh on 8/3/2016.
 */
public class CollsionPool implements iBaseController {

    Vector<iColliable> colliableVector;

    private CollsionPool() {
        colliableVector = new Vector<>();
    }

    public void add(iColliable colliable) {
        this.colliableVector.add(colliable);
    }
    public int size() {
        return colliableVector.size();
    }
    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void run() {
        for (int i = 0; i < colliableVector.size() - 1; i++) {
            for (int j = i + 1; j < colliableVector.size(); j++) {
                iColliable ci = colliableVector.get(i);
                iColliable cj = colliableVector.get(j);
                GameObject gi = ci.getGameObject();
                GameObject gj = cj.getGameObject();
                if (gi.overlap(gj)) {
                    ci.onCollide(cj);
                    cj.onCollide(ci);
                }

            }
        }
        Iterator<iColliable> colliableIterator = colliableVector.iterator();
        while (colliableIterator.hasNext()) {
            iColliable colliable = colliableIterator.next();
            if (!colliable.getGameObject().isAlive()) {
                colliableIterator.remove();
            }
        }
    }

    public static final CollsionPool instance = new CollsionPool();
}
