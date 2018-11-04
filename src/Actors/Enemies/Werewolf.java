package Actors.Enemies;

import Actors.Enemy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Werewolf extends Enemy {

    BufferedImage sprite;

    public Werewolf(String name, int size, String race, int level, int speed, int health, int dmg, boolean ranged) {
        super(name, size, race, level, speed, health, dmg, ranged);
        try {
            sprite = ImageIO.read(new File("img\\enemies\\werewolf.png"));
        } catch (Exception e){}
    }
}
