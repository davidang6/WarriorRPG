package Game;

import java.awt.*;

public class Menu {

    private Rectangle playButton, helpButton, quitButton;
    private int centerStart;
    private int length, width;

    private Font font, font2;
    private FontMetrics fm;

    public Menu(){
        centerStart = 600;
        playButton = new Rectangle(centerStart, 200, 400, 150);
        helpButton = new Rectangle(centerStart, 400, 400, 150);
        quitButton = new Rectangle(centerStart, 600, 400, 150);

        font = new Font("Product Sans",Font.PLAIN, 100);
        font2 = new Font("Product Sans", Font.PLAIN, 50);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,1600,900);

        g2d.setFont(font);
        fm = g2d.getFontMetrics();

        g2d.setColor(Color.WHITE);
        g2d.drawString("Warrior RPG", 528,100);

        g2d.setFont(font2);
        fm = g2d.getFontMetrics();
        g2d.draw(playButton);
        g2d.drawString("Play",800-fm.stringWidth("Play")/2,(int)(playButton.getY()+playButton.getHeight()/2+25));
        g2d.draw(helpButton);
        g2d.drawString("Help",800-fm.stringWidth("Help")/2,(int)(helpButton.getY()+helpButton.getHeight()/2+25));
        g2d.draw(quitButton);
        g2d.drawString("Quit",800-fm.stringWidth("Quit")/2,(int)(quitButton.getY()+quitButton.getHeight()/2+25));
    }

    public Rectangle getPlayButton() {
        return playButton;
    }

    public void setPlayButton(Rectangle playButton) {
        this.playButton = playButton;
    }

    public Rectangle getHelpButton() {
        return helpButton;
    }

    public void setHelpButton(Rectangle helpButton) {
        this.helpButton = helpButton;
    }

    public Rectangle getQuitButton() {
        return quitButton;
    }

    public void setQuitButton(Rectangle quitButton) {
        this.quitButton = quitButton;
    }

    public int getCenterStart() {
        return centerStart;
    }

    public void setCenterStart(int centerStart) {
        this.centerStart = centerStart;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
