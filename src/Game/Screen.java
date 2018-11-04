package Game;

import Actors.*;
import Actors.Enemies.Goblin;
import Objects.Weapon;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Screen extends JPanel{

    public enum STATE{
        GAME, MENU
    }
    public static STATE state = STATE.MENU;
    private Menu menu;

    private BufferedImage background;

    private ActionListener gameTimer;
    private Timer timer;
    private MouseClick mouseClick;
    private MouseMotion mouseMotion;
    private Font font;

    private static final int WIDTH = 1600, HEIGHT = 900;
    private Warrior warrior;

    private ArrayList<Projectile> projectiles;
    private ArrayList<Enemy> enemies;

    public Screen(){
        //set up the screen
        setFocusable(true);
        setPreferredSize(new Dimension(1600,900));

        menu = new Menu();

        //create the main character, give default weapon, and initialize the list of projectiles
        warrior = new Warrior(100,100);
        warrior.setWeapon(new Weapon("Pea Shooter",100,true, 5, null, null, 20));
        projectiles = new ArrayList<>();
        enemies = new ArrayList<>();

        //set the game timer
        gameTimer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        };
        timer = new Timer(15,gameTimer);

        //set up mouse listener
        mouseClick = new MouseClick();
        addMouseListener(mouseClick);

        mouseMotion = new MouseMotion();
        addMouseMotionListener(mouseMotion);

        //set game font to BEAUTIFUL Product Sans
        font = new Font("Product Sans",Font.PLAIN,30);

        //set up screen background
        try {
            background = ImageIO.read(new File("img\\backgrounds\\forest.png"));
        } catch (Exception e){}

        start();
    }

    //getWarrior() required for keybinds in Frame
    public Warrior getWarrior(){
        return warrior;
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);


        if(state == STATE.GAME) {
            //sets background to black
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, WIDTH, HEIGHT);

            //sets background to jungle image
            g2d.drawImage(background,0,0,null);

            //moves the warrior
            warrior.move();
            warrior.draw(g2d);

            //adds enemies to the field at a particular rate
            if ((int) (Math.random() * 300) == 50) {
                enemies.add(new Goblin("Goon", 50, null, 1, 1, 20, 2, true));
            }

            //adds projectiles from each enemy at a particular rate
            for (int i = 0; i < enemies.size(); i++){
                Enemy e = enemies.get(i);
                if ((int) (Math.random() * 500) == 50) {
                    double angle = Math.atan2((warrior.getY() + 50) - e.getY(), (warrior.getX() + 50) - e.getX());
                    projectiles.add(new Projectile(false, e.getX() + e.getSize()/2, e.getY() + e.getSize()/2, e.getDmg(), angle, e.getProjectileSpeed(), e.getProjectileImage()));
                }
            }

            //moves each enemy and checks for exit
            for (int i = 0; i < enemies.size(); i++) {
                Enemy e = enemies.get(i);
                double rotationRequired = Math.atan2(e.getY() - (warrior.getY()+e.getSize()/2), e.getX() - (warrior.getX()+e.getSize()/2));
                e.setRotationRequired(rotationRequired);
                e.move();
                e.draw(g2d);
                if (!enemies.isEmpty() && (e.getX() > 1600 || e.getX() < 0)) {
                    enemies.remove(i);
                    if (i > 0) i--;
                }
                if (!enemies.isEmpty() && (e.getY() > 815 || e.getY() < 0)) {
                    enemies.remove(i);
                    if (i > 0) i--;
                }
            }

            //moves each projectile and checks for exit
            for (int i = 0; i < projectiles.size(); i++) {
                projectiles.get(i).move();
                projectiles.get(i).draw(g2d);
                if (!projectiles.isEmpty() && (projectiles.get(i).getX() > 1600 || projectiles.get(i).getX() < 0)) {
                    projectiles.remove(i);
                    if (i > 0) i--;
                }
                if (!projectiles.isEmpty() && (projectiles.get(i).getY() > 830 || projectiles.get(i).getY() < 0)) {
                    projectiles.remove(i);
                    if (i > 0) i--;
                }
            }

            //checks for collision with enemies
            for (int i = 0; i < projectiles.size(); i++) {
                for (int j = 0; j < enemies.size(); j++) {
                    if (!projectiles.isEmpty() && !enemies.isEmpty() && projectiles.get(i).getBorder().intersects(enemies.get(j).getBorder()) && projectiles.get(i).isHostile()) {
                        enemies.get(j).setHealth(enemies.get(j).getHealth() - warrior.getWeapon().getDmg());
                        if (enemies.get(j).getHealth() <= 0) {
                            warrior.setE(warrior.getE() + enemies.get(j).getLevel());
                            if (warrior.getE() > warrior.geteMax()) {
                                warrior.setLevel(warrior.getLevel() + 1);
                                warrior.setE(0);
                            }
                            projectiles.remove(i);
                            enemies.remove(j);
                            if (i != 0) i--;
                            if (j != 0) j--;
                        } else {
                            projectiles.remove(i);
                            if (i != 0) i--;
                        }
                    }
                }
            }

            //checks for collision with warrior
            for (int i = 0; i < projectiles.size(); i++) {
                if (!projectiles.isEmpty() && projectiles.get(i).getBorder().intersects(warrior.getBorder()) && !projectiles.get(i).isHostile()){
                    warrior.setH(warrior.getH() - projectiles.get(i).getDmg());
                    projectiles.remove(i);
                    if (i != 0) i--;
                }
            }

            //draw health, mana, and exp progress bars
            g2d.setStroke(new BasicStroke(30));
            g2d.setColor(new Color(128, 0, 0));
            g2d.drawLine(0, 855, (int) (770 * ((warrior.getH() * 1.0) / (warrior.gethMax() * 1.0))), 855);
            g2d.setColor(new Color(0, 0, 128));
            g2d.drawLine(0, 885, (int) (770 * ((warrior.getM() * 1.0) / (warrior.getmMax() * 1.0))), 885);
            g2d.setColor(new Color(0, 128, 0));
            g2d.drawLine(800, 855, (int) (770 * ((warrior.getE() * 1.0) / (warrior.geteMax() * 1.0))) + 800, 855);

            //draw health, mana, and exp text indicators
            g2d.setFont(font);
            g2d.setColor(Color.WHITE);
            g2d.drawString("Health: " + warrior.getH() + " / " + warrior.gethMax(), 0, 865);
            g2d.drawString("Mana: " + warrior.getM() + " / " + warrior.getmMax(), 0, 895);
            g2d.drawString("EXP: " + warrior.getE() + " / " + warrior.geteMax(), 790, 865);

            //draw rest of text indicators
            g2d.drawString("Level: " + warrior.getLevel(), 790, 895);
        }
        else if (state == STATE.MENU){
            menu.paint(g2d);
        }
    }

    public void start(){
        timer.start();
    }

    public void stop(){
        timer.stop();
    }

    public static STATE getState() {
        return state;
    }

    public static void setState(STATE state) {
        Screen.state = state;
    }

    private class MouseClick implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            int mx = e.getX();
            int my = e.getY();
            if(state == STATE.GAME) {
                //upon mouse release, shoot the bullet at an angle relative to the mouse
                double angle = Math.atan2(my - (warrior.getY() + 50), mx - (warrior.getX() + 50));
                projectiles.add(new Projectile(true, warrior.getX() + 50, warrior.getY() + 50, warrior.getWeapon().getDmg(), angle, warrior.getWeapon().getProjectileSpeed(), warrior.getWeapon().getProjectileImage()));
            }
            else if(state == STATE.MENU){
                if(mx > menu.getPlayButton().getX() && mx < menu.getPlayButton().getX()+menu.getPlayButton().getWidth()){
                    if(my > menu.getPlayButton().getY() && my < menu.getPlayButton().getY()+menu.getPlayButton().getHeight()){
                        state = STATE.GAME;
                    }
                }
                if(mx > menu.getQuitButton().getX() && mx < menu.getQuitButton().getX()+menu.getQuitButton().getWidth()){
                    if(my > menu.getQuitButton().getY() && my < menu.getQuitButton().getY()+menu.getQuitButton().getHeight()){
                        System.exit(0);
                    }
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class MouseMotion extends JPanel implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            //upon mouse movement, point the character at the mouse
            double rotationRequired = Math.atan2(e.getY() - (warrior.getY()+50), e.getX() - (warrior.getX()+50));
            warrior.setRotationRequired(rotationRequired);
        }
    }

    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
    }

}
