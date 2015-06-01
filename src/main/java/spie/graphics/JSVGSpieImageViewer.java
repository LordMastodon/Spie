package spie.graphics;

import org.apache.batik.swing.svg.JSVGComponent;
import spie.util.SpiePoint;

import java.awt.image.ImageObserver;
import java.util.List;

public abstract class JSVGSpieImageViewer extends JSVGComponent {

    private boolean animate = false;

    private SVGImage image;

    public List<SVGImage> getImagesToAnimate() {
        return imagesToAnimate;
    }

    public void setImagesToAnimate(List<SVGImage> imagesToAnimate) {
        this.imagesToAnimate = imagesToAnimate;
    }

    List<SVGImage> imagesToAnimate;

    private SpiePoint spiePoint = new SpiePoint(0, 0);

    public void setImage(SVGImage newImage) {
        image = newImage;
    }

    public SVGImage getImage() {
        return image;
    }

    public SpiePoint getSpiePoint() {
        return spiePoint;
    }

    public void setSpiePoint(int x, int y) {
        spiePoint = new SpiePoint(x, y);
    }

    public void startAnimating(JSVGSpieImageViewer viewer, int... intervals) {
        animate = true;
        if (getImagesToAnimate().size() == intervals.length) {
            throw new IllegalArgumentException("You provided different amounts of arguments.");
        } else {
            while (animate) {
                for (int i = 0; i < getImagesToAnimate().size(); i++) {
                    if (i == getImagesToAnimate().size()) {
                        i = 0;
                    } else {
                        image = getImagesToAnimate().get(i);
                        viewer.invokePropertyChange(getImagesToAnimate().get(i));

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

    public void invokePropertyChange(SVGImage newImage) {
        //do some random display image changing
        image.getGraphics().drawImage(newImage, this.getSpiePoint().getX(), this.getSpiePoint().getY(), this.getImageObserver());
    }

    public abstract ImageObserver getImageObserver();
}