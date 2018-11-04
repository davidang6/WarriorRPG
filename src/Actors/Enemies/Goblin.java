package Actors.Enemies;

import Actors.Enemy;
import Actors.Projectile;
import Actors.Warrior;
import Game.Screen;
import Objects.Weapon;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

public class Goblin extends Enemy{

    private BufferedImage sprite;


    public Goblin(String name, int size, String race, int level, int speed, int health, int dmg, boolean ranged) {
        super(name, size, race, level, speed, health, dmg, ranged);
        try {
            sprite = ImageIO.read(new File("img\\enemies\\goblin.png"));
            setProjectileImage(ImageIO.read(new File("img\\bullets\\greenBullet.png")));
        } catch (Exception e){}

        setProjectileSpeed(10);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform tx = AffineTransform.getRotateInstance(getRotationRequired(), getSize()/2, getSize()/2);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        g2d.drawImage(op.filter(sprite,null), getX(), getY(),null);

        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.WHITE);
        g2d.drawRect(getX()-23,getY()+getSize()+12,getSize() + 46,getSize()/10 + 2);

        g2d.setStroke(new BasicStroke(getSize()/10));
        g2d.setColor(new Color(0,128,0));
        g2d.drawLine(getX()-20,getY()+15+getSize(),getX()-20+(int)((getSize()+40)*((getHealth()*1.0)/(getMaxHealth()*1.0))),getY()+15+getSize());
    }
}
