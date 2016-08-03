import controllers.CollsionPool;
import controllers.EBulletManager;
import controllers.EnemyManager;
import controllers.PlaneController;
import untils.Untils;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Created by KhacThanh on 8/3/2016.
 */
public class GameWindow extends Frame implements Runnable {


    BufferedImage bufferedImage;
    Graphics bufferedImageGraphic;
    Image background;
    Thread thread;
    EnemyManager enemyManager;
//    class AddEnemy extends Thread {
//        @Override
//        public void run() {
//            while (true) {
//                //listEnemy.add(new EnemyPlane(r.nextInt(400) + 50, 0));
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public GameWindow() {
        //ae = new AddEnemy();

        setSize(600, 800);
        setVisible(true);
        setLocation(0, 0);
        bufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        bufferedImageGraphic = bufferedImage.getGraphics();
        enemyManager = new EnemyManager();
        //ae.start();
        //LOAD IMAGE

        background = Untils.loadImage("background");


        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {

            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });
        this.addKeyListener(PlaneController.getPlaneController());
        this.thread = new Thread(this);
        thread.start();

    }

    @Override
    public void update(Graphics graphics) {

        bufferedImageGraphic.drawImage(background, 0, 0, null);
        PlaneController.getPlaneController().draw(bufferedImageGraphic);
        enemyManager.draw(bufferedImageGraphic);
       // EBulletManager.instance.draw(bufferedImageGraphic);
        graphics.drawImage(bufferedImage, 0, 0, null);
    }
    int cd = 0;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(17);
                PlaneController.getPlaneController().run();
                enemyManager.run();
                //EBulletManager.instance.run();
                CollsionPool.instance.run();
                if(cd % 100 == 0) {
                    System.out.println("HP : " + PlaneController.getPlaneController().getGameObject().getHp() + "  Enemy : " + enemyManager.size() + "  CollsionPool : " + CollsionPool.instance.size());
                }
                cd++;
                repaint();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
