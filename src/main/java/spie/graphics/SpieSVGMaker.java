package spie.graphics;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.anim.dom.SVGOMSVGElement;
import org.apache.batik.bridge.*;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.IOException;

public class SpieSVGMaker {
    private static final String PATH_ELEMENT_NAME = "path";

    private Document svgDocument;

    public SpieSVGMaker(String uri) throws IOException {
        setSVGDocument(createSVGDocument(uri));
    }

    public void run() {
        NodeList pathNodes = getPathElements();
        int pathNodeCount = pathNodes.getLength();

//        for(int iPathNode = 0; iPathNode < pathNodeCount; iPathNode++) {
//            MetaPostPath mpp = new MetaPostPath(pathNodes.item(iPathNode));
//            System.out.println(mpp.toCode());
//        }
    }

    private NodeList getPathElements() {
        return getSVGDocumentRoot().getElementsByTagName(PATH_ELEMENT_NAME);
    }

    private SVGOMSVGElement getSVGDocumentRoot() {
        return (SVGOMSVGElement) getSVGDocument().getDocumentElement();
    }

    public void setSVGDocument(Document doc) {
        initSVGDOM(doc);

        svgDocument = doc;
    }

    public Document getSVGDocument() {
        return svgDocument;
    }

    private void initSVGDOM(Document doc) {
        UserAgent userAgent = new UserAgentAdapter();
        DocumentLoader loader = new DocumentLoader(userAgent);
        BridgeContext bridgeContext = new BridgeContext(userAgent, loader);
        bridgeContext.setDynamicState(BridgeContext.DYNAMIC);

        (new GVTBuilder()).build(bridgeContext, doc);
    }

    private Document createSVGDocument(String uri) throws IOException {
        String parser = XMLResourceDescriptor.getXMLParserClassName();
        SAXSVGDocumentFactory factory = new SAXSVGDocumentFactory(parser);

        return factory.createDocument(uri);
    }

}
