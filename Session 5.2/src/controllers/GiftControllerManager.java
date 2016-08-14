package controllers;


import models.Gift;
import views.ImageDrawer;

import java.util.Random;

/**
 * Created by KhacThanh on 8/9/2016.
 */
public class GiftControllerManager extends ControllerManager {
    private int count;
    private static final int RESPAWN_TYPE1 = 150;
    private static final int RESPAWN_TYPE2 = 250;
    private Random rd = new Random();

    @Override
    public void run() {
        super.run();
        count++;


        if (count == RESPAWN_TYPE2) {
            count = 0;
            /* TODO: Generate plane controller 2 */

            GiftController giftController = new GiftController(
                    new Gift(rd.nextInt(300) + 200, 0),
                    new ImageDrawer("resources/boom.png")
            );
            this.add(giftController);

        } else if (count == RESPAWN_TYPE1) {
            GiftController2 giftController2 = new GiftController2(
                    new Gift(rd.nextInt(300) + 200, 0),
                    new ImageDrawer("resources/boom2.png")
            );
            this.add(giftController2);
        }
    }
    public final static GiftControllerManager instance = new GiftControllerManager();
}

