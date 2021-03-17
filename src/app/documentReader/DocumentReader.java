package app.documentReader;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class DocumentReader {
    private final Document document;

    public DocumentReader(Document document) {
        this.document = document;
    }

    protected NodeList getData(String element) {
        return document.getDocumentElement()
                .getElementsByTagName(element.trim());
    }

    protected String getTextContent(String element, int i) {
        return getData(element).item(i).getTextContent();
    }

    protected String getAttributeValue(String element, int i, String attribute) {
        return getData(element)
                .item(i)
                .getAttributes()
                .getNamedItem(attribute)
                .getNodeValue();
    }
}
