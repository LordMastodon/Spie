package spie.graphics;

import spie.util.SpieGraphicsEnvironment;
import spie.util.SpiePoint;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public abstract class SpieImage extends Image {

    private boolean animate = false;

    private SpieImage image;

    private SpiePoint spiePoint = new SpiePoint(0, 0);

    public void setImage(SpieImage newImage) {
        image = newImage;
    }

    public SpieImage getImage() {
        return image;
    }

    public SpiePoint getSpiePoint() {
        return spiePoint;
    }

    public void setSpiePoint(int x, int y) {
        spiePoint = new SpiePoint(x, y);
    }

    public void startAnimating(ArrayList<SpieImage> images, int... intervals) {
        animate = true;
        if (images.size() == intervals.length) {
            throw new IllegalArgumentException("You provided different amounts of arguments.");
        } else {
            while (animate) {
                for (int i = 0; i < images.size(); i++) {
                    if (i == images.size()) {
                        i = 0;
                    } else {
                        image = images.get(i);
                        image.invokePropertyChange(images.get(i));

                        try {
                            Thread.sleep(intervals[i]);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void stopAnimating() {
        animate = false;
    }

    public void invokePropertyChange(SpieImage image) {
        //do some random display image changing here
        image.getGraphics().drawImage(image, image.getSpiePoint().getX(), image.getSpiePoint().getY(), image.getImageObserver());
    }

    public Graphics getGraphics() {
        return SpieGraphicsEnvironment.getSpieGraphicsEnvironment().createGraphics(this);
    }

    public abstract ImageObserver getImageObserver();
}