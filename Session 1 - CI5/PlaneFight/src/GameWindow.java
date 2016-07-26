import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by KhacThanh on 7/25/2016.
 */
public class GameWindow extends Frame implements Runnable{
    private static final int HAFT_LENGHT_PLANE = 35;
    private static final int HAFT_LENGHT_BULLET = 6;
    private static final int DISTANCE_ENOUGH = 46;
    class Bullet{
        boolean flip;
        int bulletX;
        int bulletY;
        public Bullet(boolean flip, int x, int y){
            this.flip = flip;
            this.bulletX = x;
            this.bulletY = y;
        }
    }
    BufferedImage bufferedImage;
    Graphics bufferedImageGraphic;
    Image background;
    Image plane1;
    Image plane2;
    Image bullet;
    Image bullet_flip;
    int planeX1=270;
    int planeX2=230;
    int planeY1=600;
    int planeY2=600;
    Thread thread;
    ArrayList<Bullet> listBullet = new ArrayList<Bullet>();


    public GameWindow(){

        setSize(600,800);
        setVisible(true);
        setLocation(0,0);
        bufferedImage = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        bufferedImageGraphic = bufferedImage.getGraphics();
        this.thread = new Thread(this);
        thread.start();
        try {
            background = ImageIO.read(new File("resources/background.png"));
            plane1 = ImageIO.read(new File("resources/plane3.png"));
            plane2 = ImageIO.read(new File("resources/plane1.png"));
            bullet = ImageIO.read(new File("resources/bullet.png"));
            bullet_flip = ImageIO.read(new File("resources/bullet_flip.png"));
        }catch (IOException e){
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
                switch (keyEvent.getKeyCode()){
                    case KeyEvent.VK_UP:
                        planeY1 -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        planeY1 += 10;
                        break;
                    case KeyEvent.VK_LEFT:
                        planeX1 -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        planeX1 += 10;
                        break;
                    case KeyEvent.VK_SPACE:
                        listBullet.add(new Bullet(true, planeX1 + 29, planeY1-41));
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
                planeX2 = mouseEvent.getX() - 35;
                planeY2 = mouseEvent.getY() - 30;
            }
        });
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                listBullet.add(new Bullet(false, planeX2 + 29 , planeY2 + 59));

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

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
        int xb1;
        int xb2;
        int xp1;
        int xp2;
        int distance;

        bufferedImageGraphic.drawImage(background, 0, 0, null);
        bufferedImageGraphic.drawImage(plane1, planeX1, planeY1, null);
        bufferedImageGraphic.drawImage(plane2, planeX2, planeY2, null);
        for(int i=0; i<listBullet.size(); i++){
            // CHECK DISTANCE
            xb1 = listBullet.get(i).bulletX - HAFT_LENGHT_BULLET;
            xb2 = listBullet.get(i).bulletX + HAFT_LENGHT_BULLET;
            xp1 = planeX2 - HAFT_LENGHT_PLANE;
            xp2 = planeX2 + HAFT_LENGHT_PLANE;
            distance = listBullet.get(i).bulletY - planeY2;
            // CHECK OUT
            if(listBullet.get(i).bulletY < 0 ||
                    listBullet.get(i).bulletY > 800){
                listBullet.remove(i);
            } else {
                if(listBullet.get(i).flip){
                    listBullet.get(i).bulletY -=5;
                    bufferedImageGraphic.drawImage(bullet, listBullet.get(i).bulletX, listBullet.get(i).bulletY, null);
                } else {
                    listBullet.get(i).bulletY +=5;
                    bufferedImageGraphic.drawImage(bullet_flip, listBullet.get(i).bulletX, listBullet.get(i).bulletY, null);
                }
            }
            //CHECK EXPLOSION
            if(xb2 > xp1 && xb1 < xp2 && distance < DISTANCE_ENOUGH){
                System.out.println("BUM BUM");
                listBullet.remove(i);
            }
        }
        graphics.drawImage(bufferedImage,0,0,null);
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(27);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
