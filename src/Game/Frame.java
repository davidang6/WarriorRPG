package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

    private Screen s;

    public Frame(){
        //have the program close on exit
        setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);

        //set title of the window
        setTitle("Warrior RPG");

        //make the game permanently 1600x900
        setResizable(false);

        //initiate
        init();
    }

    public void init(){
        //set 1x1 GridLayout
        setLayout(new GridLayout(1,1,0,0));

        //add the screen to the frame
        s = new Screen();
        add(s);

        //set the listeners for keys
        keyBinds();

        //organizing the frame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }


    //set all keymaps in the game here
    @SuppressWarnings("serial")
    private void keyBinds() {
        InputMap events = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actions = getRootPane().getActionMap();

        events.put(KeyStroke.getKeyStroke("W"), "W pressed");
        events.put(KeyStroke.getKeyStroke("released W"), "W released");
        actions.put("W pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.getWarrior().setUp((-1)*s.getWarrior().getSpeed());
            }
        });
        actions.put("W released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.getWarrior().setUp(0);
            }
        });

        events.put(KeyStroke.getKeyStroke("A"), "A pressed");
        events.put(KeyStroke.getKeyStroke("released A"), "A released");
        actions.put("A pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.getWarrior().setLeft((-1)*s.getWarrior().getSpeed());
            }
        });
        actions.put("A released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.getWarrior().setLeft(0);
            }
        });

        events.put(KeyStroke.getKeyStroke("S"), "S pressed");
        events.put(KeyStroke.getKeyStroke("released S"), "S released");
        actions.put("S pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.getWarrior().setDown(s.getWarrior().getSpeed());
            }
        });
        actions.put("S released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.getWarrior().setDown(0);
            }
        });

        events.put(KeyStroke.getKeyStroke("D"), "D pressed");
        events.put(KeyStroke.getKeyStroke("released D"), "D released");
        actions.put("D pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.getWarrior().setRight(s.getWarrior().getSpeed());
            }
        });
        actions.put("D released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.getWarrior().setRight(0);
            }
        });

        events.put(KeyStroke.getKeyStroke("released ESCAPE"), "Escape released");
        actions.put("Escape released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Screen.setState(Screen.STATE.MENU);
            }
        });
    }

    //create a new Frame, which has the entire game
    public static void main (String [] args){
        new Frame();
    }
}
