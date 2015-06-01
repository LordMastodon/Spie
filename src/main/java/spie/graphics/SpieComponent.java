package spie.graphics;

import spie.util.SpiePoint;

import javax.swing.*;

public class SpieComponent extends JComponent {

    private SpiePoint preferredPosition;

    public void setPreferredPosition(SpiePoint newSpiePoint) {
        preferredPosition = newSpiePoint;
    }

    public SpiePoint getPreferredPosition() {
        return preferredPosition;
    }

}
