package spie.util;

import java.awt.*;
import java.util.ArrayList;

public abstract class SpieImage extends Image {

    boolean animate = false;

    SpieImage image;

    public void setImage(SpieImage newImage) {
        image = newImage;
    }

    public SpieImage getImage() {
        return image;
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
                        image.invokePropertyChange();

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

    public void invokePropertyChange() {
        //do some random display image changing here   
    }

    public Graphics getGraphics() {
        return SpieGraphicsEnvironment.getSpieGraphicsEnvironment().createGraphics(this);
    }
}