package Objects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Projectile {

    private boolean hostile;

    private double xVelocity, yVelocity, angle, bulletVelocity;

    private int x, y, dmg;

    private BufferedImage image;

    public Projectile(boolean hostile, final int x, final int y, int dmg, final double angle, final double bulletVelocity, BufferedImage image) {
        this.hostile = hostile;
        this.x = x;
        this.y = y;
        this.dmg = dmg;
        this.angle = angle;
        this.bulletVelocity = bulletVelocity;
        this.image = image;
    }


    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);

        if (image != null) try {
            g2d.drawImage(image, x, y, null);
        } catch (Exception e) {
        }
        else g2d.fillOval(x, y, 15, 15);
    }


    public void move() {
        xVelocity = (bulletVelocity) * Math.cos(angle);
        yVelocity = (bulletVelocity) * Math.sin(angle);
        x += xVelocity;
        y += yVelocity;

    }

    public Rectangle getBorder() {
        return new Rectangle(x, y, 15, 15);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isHostile() {
        return hostile;
    }

    public void setHostile(boolean hostile) {
        this.hostile = hostile;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
}
