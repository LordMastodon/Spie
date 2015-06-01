package spie.graphics;

import java.net.URI;

abstract class SVGImage extends SpieImage {

    private URI uri;

    public void setUri(URI newURI) {
        uri = newURI;
    }

    public URI getUri() {
        return uri;
    }

    public SVGImage getByURI(URI uri) {
        return new SVGImage(uri) {};
    }

    private SVGImage(URI uri) {
        this.uri = uri;
    }
}
