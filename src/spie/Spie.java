package spie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Spie extends JFrame {

    //Game vision: A space game where you formalize the most powerful pie.

    private void addComponentsToPane() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(panel);
        setLayout(new BorderLayout());
    }

    public Spie(String name) {
        super(name);
    }

    public static void main(String[] args) {

    }

}
