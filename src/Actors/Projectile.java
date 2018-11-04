package Actors;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Projectile{


    private double xVelocity, yVelocity, angle, bulletVelocity;

    private int x, y;

    private BufferedImage image;

    public Projectile(final int x, final int y, final double angle, final double bulletVelocity, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.bulletVelocity = bulletVelocity;
        this.image = image;
    }


    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.RED);

        if(image != null) try{
            g2d.drawImage(image,x,y,null);
        }catch (Exception e){}
        else g2d.fillOval(x,y,15,15);
    }


    public void move() {
        xVelocity = (bulletVelocity) * Math.cos(angle);
        yVelocity = (bulletVelocity) * Math.sin(angle);
        x += xVelocity;
        y += yVelocity;

    }

    public Rectangle getBorder(){
        return new Rectangle(x,y,15,15);
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
}
