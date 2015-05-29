package spie.util;

import java.awt.*;

public class SpieImage extends Image {

    boolean animate = false;

    SpieImage image;

    public void setImage(SpieImage newImage) {
        image = newImage;
    }

    public SpieImage getImage() {
        return image;
    }

    public void startAnimating(SpieImage... images, int... intervals) {
        animate = true;
        if(images.length != intervals.length) {
            throw new IllegalArgumentException("You provided different amounts of arguments.");
        } else {
            while(animate) {
                for(int i = 0; i < images.length; i++) {
                    if(!i < images.length) {
                        i = 0;
                    } else {
                        image = images[i];
                        image.invokePropertyChange();
                        Thread.sleep(intervals[i]);
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
