import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import models.*;

/**
 * Created by KhacThanh on 7/25/2016.
 */
public class GameWindow extends Frame implements Runnable {
    private static final int HAFT_LENGHT_PLANE = 35;
    private static final int HAFT_LENGHT_BULLET = 6;
    private static final int HAFT_SIZE_ENEMY = 16;
    private static final int DISTANCE_ENOUGH = 32;

    BufferedImage bufferedImage;
    Graphics bufferedImageGraphic;
    Image background;
    Image imagePlane1;
    Image imagePlane2;
    Image imageEnemy;
    Image bullet;
    Image bullet_flip;

    Plane plane1;
    Plane plane2;
    Thread thread;
    ArrayList<Bullet> listBullet = new ArrayList<Bullet>();
    ArrayList<Enemy> listEnemy = new ArrayList<Enemy>();
    Random r = new Random();
    AddEnemy ae;
    class AddEnemy extends Thread {
        @Override
        public void run() {
            while(true) {
                listEnemy.add(new Enemy(r.nextInt(400) + 50, 0));
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public GameWindow() {
        ae = new AddEnemy();
        plane1 = new Plane(270, 600);
        plane2 = new Plane(230, 600);
        r = new Random();
        setSize(600, 800);
        setVisible(true);
        setLocation(0, 0);
        bufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        bufferedImageGraphic = bufferedImage.getGraphics();
        this.thread = new Thread(this);
        thread.start();
        ae.start();
        try {
            background = ImageIO.read(new File("resources/background.png"));
            imagePlane1 = ImageIO.read(new File("resources/plane3.png"));
            imagePlane2 = ImageIO.read(new File("resources/plane1.png"));
            imageEnemy = ImageIO.read(new File("resources/enemy_plane_yellow_1.png"));
            bullet = ImageIO.read(new File("resources/bullet.png"));
            bullet_flip = ImageIO.read(new File("resources/bullet_flip.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

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
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        plane1.y -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        plane1.y += 10;
                        break;
                    case KeyEvent.VK_LEFT:
                        plane1.x -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane1.x += 10;
                        break;
                    case KeyEvent.VK_SPACE:
                        listBullet.add(new Bullet(plane1.x + 29, plane1.y - 41, true));
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                plane2.MoveTo(mouseEvent.getX(), mouseEvent.getY());
            }
        });
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                listBullet.add(new Bullet(plane2.x + 29, plane2.y + 59, false));
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                listBullet.add(new Bullet(plane2.x + 29, plane2.y + 59, false));
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
    }

    @Override
    public void update(Graphics graphics) {

        bufferedImageGraphic.drawImage(background, 0, 0, null);
        bufferedImageGraphic.drawImage(imagePlane1, plane1.x, plane1.y, null);
        bufferedImageGraphic.drawImage(imagePlane2, plane2.x, plane2.y, null);
        for (int i = 0; i < listBullet.size(); i++) {
            if (listBullet.get(i).flip) {
                bufferedImageGraphic.drawImage(bullet, listBullet.get(i).x, listBullet.get(i).y, null);
            } else {
                bufferedImageGraphic.drawImage(bullet_flip, listBullet.get(i).x, listBullet.get(i).y, null);
            }
        }
        for (int i = 0; i < listEnemy.size(); i++) {
            bufferedImageGraphic.drawImage(imageEnemy, listEnemy.get(i).x, listEnemy.get(i).y, null);
        }
        graphics.drawImage(bufferedImage, 0, 0, null);
    }
///listEnemy.add(new Enemy(r.nextInt(400)+50, 0));
    @Override
    public void run() {
        while (true) {
            try {
                thread.sleep(27);
                Iterator<Enemy> enemyPlaneIterator = listEnemy.iterator();
                Enemy enemy;
                while (enemyPlaneIterator.hasNext()) {
                    enemy = enemyPlaneIterator.next();
                    enemy.y += 7;
                    if (enemy.y > 759) {
                        enemyPlaneIterator.remove();
                        break;
                    }
                }
                Iterator<Bullet> bulletIterator = listBullet.iterator();
                while (bulletIterator.hasNext()) {
                    Bullet bullet = bulletIterator.next();
                    bullet.y -= 10;
                    if (bullet.y <= 0) {
                        bulletIterator.remove();
                    }

                }
                try {
                    for (Enemy plane : listEnemy) {
                        for (Bullet bullet : listBullet) {
                            if (plane.y + 32 >= bullet.y && plane.y < bullet.y && plane.x < bullet.x && plane.x + 32 > bullet.x) {
                                listBullet.remove(bullet);
                                listEnemy.remove(plane);
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    }

