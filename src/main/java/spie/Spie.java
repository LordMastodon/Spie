package spie;

import org.apache.batik.apps.svgbrowser.Application;
import org.apache.batik.apps.svgbrowser.JSVGViewerFrame;
import org.apache.batik.util.resources.ResourceManager;
import spie.graphics.SpieSVGMaker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Locale;
import java.util.ResourceBundle;

public class Spie implements Application {
    public static final String UNKNOWN_SCRIPT_TYPE_LOAD_KEY_EXTENSION = ".load";
    public static final String PROPERTY_USER_HOME = "user.home";
    public static final String PROPERTY_JAVA_SECURITY_POLICY = "java.security.policy";
    public static final String POLICY_GRANT_SCRIPT_NETWORK_ACCESS = "grant {\n permission java.net.SocketPermission \"*\", \"listen, connect, resolve, accept\";\n};\n\n";
    public static final String POLICY_GRANT_SCRIPT_FILE_ACCESS = "grant {\n permission java.io.FilePermission \"<<ALL FILES>>\", \"read\";\n};\n\n";
    public static final String PREFERENCE_KEY_VISITED_URI_LIST = "preference.key.visited.uri.list.length";
    public static final String PREFERENCE_KEY_VISITED_URI_LIST_LENGTH = "preference.key.visited.uri.list.length";
    public static final String URI_SEPARATOR = " ";
    public static final String SVG_INITIALIZATION = "resources/svgTest.svg";
    protected String svgInitializationURI;
    public static final String RESOURCES = "spie.pref.Spie";
    protected static ResourceBundle bundle = ResourceBundle.getBundle("spie.pref.Spie", Locale.getDefault());
    protected static ResourceManager resources;


    //Game vision: A space game where you formalize the most powerful pie.

    private void addComponentsToPane() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(panel);
        setLayout(new BorderLayout());
    }

    private static void createAndShowGUI() {
        Spie spie = new Spie("Spie");
        spie.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        spie.addComponentsToPane();

        spie.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        spie.setVisible(true);
    }

    public static void main(String[] args) {
        new Spie(args);
    }

    public Spie(String[] strings) {

    }

    @Override
    public String getDefaultFontFamily() {
        return null;
    }

    @Override
    public boolean isSelectionOverlayXORMode() {
        return false;
    }

    @Override
    public boolean isXMLParserValidating() {
        return false;
    }

    @Override
    public String getMedia() {
        return null;
    }

    @Override
    public void showPreferenceDialog(JSVGViewerFrame jsvgViewerFrame) {

    }

    @Override
    public void openLink(String s) {

    }

    @Override
    public String getXMLParserClassName() {
        return null;
    }

    @Override
    public String getUserStyleSheetURI() {
        return null;
    }

    @Override
    public int getAllowedExternalResourceOrigin() {
        return 0;
    }

    @Override
    public JSVGViewerFrame createAndShowJSVGViewerFrame() {
        return null;
    }

    @Override
    public Action createExitAction(JSVGViewerFrame jsvgViewerFrame) {
        return null;
    }

    @Override
    public String[] getVisitedURIs() {
        return new String[0];
    }

    @Override
    public int getAllowedScriptOrigin() {
        return 0;
    }

    @Override
    public String getLanguages() {
        return null;
    }

    @Override
    public boolean canLoadScriptType(String s) {
        return false;
    }

    @Override
    public void closeJSVGViewerFrame(JSVGViewerFrame jsvgViewerFrame) {

    }

    @Override
    public void addVisitedURI(String s) {

    }

    @Override
    public String getUISpecialization() {
        return null;
    }
}
