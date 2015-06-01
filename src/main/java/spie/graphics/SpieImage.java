package spie.graphics;

import spie.util.SpieGraphicsEnvironment;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Hashtable;

public class SpieImage extends Image {

    Hashtable properties;

    public int getHeight(ImageObserver observer) {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth(ImageObserver observer) {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    int width;
    int height;

    public Graphics getGraphics() {
        return SpieGraphicsEnvironment.getSpieGraphicsEnvironment().createGraphics(this);
    }

    public Object getProperty(String name, ImageObserver observer) {
        return getProperty(name);
    }

    public Object getProperty(String name) {
        if (name == null) {
            throw new NullPointerException("null property name is not allowed");
        }
        if (properties == null) {
            return java.awt.Image.UndefinedProperty;
        }
        Object o = properties.get(name);
        if (o == null) {
            o = java.awt.Image.UndefinedProperty;
        }
        return o;
    }

    public ImageProducer getSource() {
        return null;
    }
}
