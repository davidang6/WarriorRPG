package Actors.Enemies;

import Actors.Enemy;

import javax.imageio.ImageIO;
import java.io.File;

public class Goblin extends Enemy{


    public Goblin(String name, int size, String race, int level, int speed, int health, int dmg, boolean ranged) {
        super(name, size, race, level, speed, health, dmg, ranged);
        try {
            setSprite(ImageIO.read(new File("img\\enemies\\goblin.png")));
            setProjectileImage(ImageIO.read(new File("img\\bullets\\greenBullet.png")));
        } catch (Exception e){}

        setProjectileSpeed(10);
    }
}
