package controllers;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by KhacThanh on 8/3/2016.
 */
public class ControllerManager implements iBaseController {
    protected Vector<SingleController> singleControllerVector;

    public ControllerManager() {
        singleControllerVector = new Vector<>();
    }

    public void add(SingleController singleController) {
        this.singleControllerVector.add(singleController);
    }
    public int size() {
        return singleControllerVector.size();
    }
    @Override
    public void draw(Graphics g) {
        for (SingleController controller : this.singleControllerVector) {
            controller.draw(g);
        }
    }

    @Override
    public void run() {
        Iterator<SingleController> singleControllerIterator = this.singleControllerVector.iterator();
        while(singleControllerIterator.hasNext()) {
            SingleController singleController = singleControllerIterator.next();
            if(!singleController.getGameObject().isAlive()) {
                singleControllerIterator.remove();
            } else {
                singleController.run();
            }
        }
    }
}
