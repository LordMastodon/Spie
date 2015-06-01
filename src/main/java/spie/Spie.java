package spie;

import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.svg.GVTTreeBuilderAdapter;
import org.apache.batik.swing.svg.GVTTreeBuilderEvent;
import org.apache.batik.swing.svg.SVGDocumentLoaderAdapter;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;
import spie.graphics.SpieComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Spie {
    //Game vision: A space game where you formalize the most powerful pie.

    public ArrayList<SpieComponent> components = new ArrayList();

    public static void main(String[] args) {
        JFrame f = new JFrame("Spie");
        Spie spie = new Spie(f);

        f.getContentPane().add(spie.createComponents());

        f.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        f.setVisible(true);
    }

    protected JFrame frame;
    protected JButton button = new JButton("Load...");
    protected JLabel label = new JLabel();
    protected JSVGCanvas svgCanvas = new JSVGCanvas();

    public Spie(JFrame f) {
        frame = f;
        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                updateComponentPositions();
            }
        });
    }

    public JComponent createComponents() {
        final JPanel panel = new JPanel(new BorderLayout());
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));

        p.add(button);
        p.add(label);

        panel.add("North", p);
        panel.add("Center", svgCanvas);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser(".");
                int choice = fc.showOpenDialog(panel);
                if(choice == JFileChooser.APPROVE_OPTION) {
                    File f = fc.getSelectedFile();
                    try {
                        svgCanvas.setURI(f.toURL().toString());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        svgCanvas.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter() {
            public void documentLoadingStarted(SVGDocumentLoaderEvent svgDocumentLoaderEvent) {
                label.setText("Document Loading...");
            }

            public void documentLoadingCompleted(SVGDocumentLoaderEvent svgDocumentLoaderEvent) {
                label.setText("Document Loaded.");
            }
        });

        svgCanvas.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter() {
            public void gvtBuildStarted(GVTTreeBuilderEvent gvtTreeBuilderEvent) {
                label.setText("Build Started...");
            }

            public void gvtBuildCompleted(GVTTreeBuilderEvent gvtTreeBuilderEvent) {
                label.setText("Build Done.");
                frame.pack();
            }
        });

        return panel;
    }

    public void updateComponentPositions() {
        for(int i = 0; i < components.size(); i++) {
            components.get(i).setLocation(components.get(i).getPreferredPosition().getX(), components.get(i).getPreferredPosition().getY());
        }
    }
}
