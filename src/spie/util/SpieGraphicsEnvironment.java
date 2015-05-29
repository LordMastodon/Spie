package spie.util;

import sun.security.action.GetPropertyAction;

import java.awt.*;
import java.security.AccessController;

public abstract class SpieGraphicsEnvironment {
    private static SpieGraphicsEnvironment sGE;

    public static synchronized SpieGraphicsEnvironment getSpieGraphicsEnvironment() {
        if (sGE.equals(null)) {
            sGE = createSGE();
        }

        return sGE;
    }

    private static SpieGraphicsEnvironment createSGE() {
        SpieGraphicsEnvironment ge;
        String nm = AccessController.doPrivileged(new GetPropertyAction("java.awt.graphicsenv", null));
        try {
            Class geCls;
            try {
                geCls = Class.forName(nm);
            } catch (ClassNotFoundException ex) {
                ClassLoader cl = ClassLoader.getSystemClassLoader();
                geCls = Class.forName(nm, true, cl);
            }
            ge = (SpieGraphicsEnvironment) geCls.newInstance();
        } catch (ClassNotFoundException e) {
            throw new Error("Could not find class: "+nm);
        } catch (InstantiationException e) {
            throw new Error("Could not instantiate Spie Graphics Environment: "
                    + nm);
        } catch (IllegalAccessException e) {
            throw new Error ("Could not access Spie Graphics Environment: "
                    + nm);
        }
        return ge;
    }

    public abstract Graphics createGraphics(Image img);

}
