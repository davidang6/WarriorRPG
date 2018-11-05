package Actors.Enemies;

import Actors.Enemy;

import javax.imageio.ImageIO;
import java.io.File;

public class Ghoul extends Enemy {

    public Ghoul(String name, int size, String race, int level, int speed, int health, int dmg, boolean ranged){
        super(name, size, race, level, speed, health, dmg, ranged);
        try {
            setSprite(ImageIO.read(new File("img\\enemies\\ghoul.png")));
            setProjectileImage(ImageIO.read(new File("img\\bullets\\grayBullet.png")));
        } catch (Exception e){}
    }
}
