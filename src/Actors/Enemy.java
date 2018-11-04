package Actors;

import java.awt.*;

public class Enemy {

    private String name;
    private int x, y, size, level, health, maxHealth, dmg;
    private String race;
    private boolean ranged;

    private int speed;

    boolean horz,vert;

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
        g2d.setStroke(new BasicStroke(size/10));
        g2d.setColor(new Color(0,128,0));
        g2d.drawLine(x-20,y+25+size,x-20+(int)((size+40)*((health*1.0)/(maxHealth*1.0))),y+25+size);
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
}
