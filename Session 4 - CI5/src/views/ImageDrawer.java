package views;

import models.GameObject;
import untils.Untils;

import java.awt.*;

/**
 * Created by KhacThanh on 8/3/2016.
 */
public class ImageDrawer implements iGameDrawer {
    private Image image;

    public ImageDrawer(String url) {
        this.image = Untils.loadImage(url);
    }

    @Override
    public void draw(Graphics g, GameObject gameObject) {
        g.drawImage(image, gameObject.getX(), gameObject.getY(), gameObject.getWidth(), gameObject.getHeight(), null);
    }


}
