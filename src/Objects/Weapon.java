package Objects;

import Actors.Projectile;

import java.awt.image.BufferedImage;

public class Weapon {

    private String name;
    private int price, dmg, projectileSpeed;
    private boolean ranged;
    private BufferedImage projectileImage, img;

    public Weapon(String name, int price, boolean ranged, int dmg, BufferedImage img, BufferedImage projectileImage, int projectileSpeed){
        this.name = name;
        this.price = price;
        this.ranged = ranged;
        this.dmg = dmg;
        this.img = img;
        this.projectileImage = projectileImage;
        this.projectileSpeed = projectileSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
}
