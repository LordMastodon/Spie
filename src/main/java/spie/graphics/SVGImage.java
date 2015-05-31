package spie.graphics;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.bridge.BridgeContext;
import org.apache.batik.bridge.GVTBuilder;
import org.apache.batik.bridge.UserAgent;
import org.apache.batik.bridge.UserAgentAdapter;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.svg.SVGDocument;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public final class SVGImage {
    private final GraphicsNode rootSVGNode;

    private final SVGDocument svgDocument;

    public SVGImage(URL url) throws IOException {
        String parser = XMLResourceDescriptor.getXMLParserClassName();
        SAXSVGDocumentFactory factory = new SAXSVGDocumentFactory(parser);

        svgDocument = (SVGDocument) factory.createDocument(url.toString());
        rootSVGNode = getRootNode(svgDocument);
    }

    public SVGImage(SVGDocument doc) {
        svgDocument = doc;
        rootSVGNode = getRootNode(svgDocument);
    }

    private static GraphicsNode getRootNode(SVGDocument doc) {
        UserAgentAdapter userAgentAdapter = new UserAgentAdapter();
        BridgeContext bridgeContext = new BridgeContext(userAgentAdapter);
        GVTBuilder builder = new GVTBuilder();

        return builder.build(bridgeContext, doc);
    }

    public GraphicsNode getRootSVGNode() {
        return rootSVGNode;
    }

    public SVGDocument getSvgDocument() {
        return svgDocument;
    }

//    public Image getImage(int width, int height) {
//
//    }
}
