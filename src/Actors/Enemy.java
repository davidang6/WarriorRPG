package Actors;

import Objects.Weapon;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {

    private String name;
    private int x, y, size, level, health, maxHealth, dmg;
    private String race;
    private boolean ranged;

    private int speed, projectileSpeed;

    private double rotationRequired;

    private boolean horz,vert;

    private BufferedImage projectileImage;

    public Enemy(String name, int size, String race, int level, int speed, int health, int dmg, boolean ranged){
        this.name = name;
        this.size = size;
        this.race = race;
        this.level = level;
        this.speed = speed;
        this.health = health;
        this.maxHealth = health;
        this.dmg = dmg;
        this.ranged = ranged;
        if((int)(Math.random()*2) == 0) {
            horz = true;
            x = 0;
            y = (int)(Math.random()*830);
        }
        else {
            vert = true;
            x = (int)(Math.random()*1550);
            y = 0;
        }
    }

    public void move(){
        if(vert){
            y++;
        }
        if(horz){
            x++;
        }
    }

    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.CYAN);
        g2d.drawRect(x,y,size,size);

        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.WHITE);
        g2d.drawRect(getX()-23,getY()+getSize()+12,getSize() + 46,getSize()/10 + 2);

        g2d.setStroke(new BasicStroke(getSize()/10));
        g2d.setColor(new Color(0,128,0));
        g2d.drawLine(getX()-20,getY()+15+getSize(),getX()-20+(int)((getSize()+40)*((getHealth()*1.0)/(getMaxHealth()*1.0))),getY()+15+getSize());
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isHorz() {
        return horz;
    }

    public void setHorz(boolean horz) {
        this.horz = horz;
    }

    public boolean isVert() {
        return vert;
    }

    public void setVert(boolean vert) {
        this.vert = vert;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public boolean isRanged() {
        return ranged;
    }

    public void setRanged(boolean ranged) {
        this.ranged = ranged;
    }

    public double getRotationRequired() {
        return rotationRequired;
    }

    public void setRotationRequired(double rotationRequired) {
        this.rotationRequired = rotationRequired;
    }

    public BufferedImage getProjectileImage() {
        return projectileImage;
    }

    public void setProjectileImage(BufferedImage projectileImage) {
        this.projectileImage = projectileImage;
    }

    public int getProjectileSpeed() {
        return projectileSpeed;
    }

    public void setProjectileSpeed(int projectileSpeed) {
        this.projectileSpeed = projectileSpeed;
    }
}
