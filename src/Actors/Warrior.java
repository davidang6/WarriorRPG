package Actors;

import Objects.Weapon;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Warrior {

    private int x, y;
    private int size;
    private int level;

    private int h, m, e;
    private int hMax, mMax, eMax;

    private int up, down, left, right;
    private int speed;

    private double rotationRequired;

    private Weapon weapon;

    private BufferedImage image;

    public Warrior(int x, int y){
        this.x = x;
        this.y = y;
        size = 100;
        speed = 5;
        level = 1;

        h = 100;
        m = 100;
        e = 0;
        hMax = 100;
        mMax = 100;
        eMax = 100;

        try {
            image = ImageIO.read(new File("img\\warrior.png"));
        } catch (Exception e){}
    }


    public void move(){
        x += left + right;
        y += up + down;

        if(x > 1500) x = 1500;
        if(y > 770) y = 770;
        if(x < 0) x = 0;
        if(y < 0) y = 0;

    }

    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, 50, 50);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        g2d.drawImage(op.filter(image, null), getX(), getY(), null);
    }

    public Rectangle getBorder(){
        return new Rectangle(x,y,size,size);
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int gethMax() {
        return hMax;
    }

    public void sethMax(int hMax) {
        this.hMax = hMax;
    }

    public int getmMax() {
        return mMax;
    }

    public void setmMax(int mMax) {
        this.mMax = mMax;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int geteMax() {
        return eMax;
    }

    public void seteMax(int eMax) {
        this.eMax = eMax;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setRotationRequired(double rotationRequired){
        this.rotationRequired = rotationRequired;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
