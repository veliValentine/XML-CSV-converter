package app.documentReader;

import app.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DocumentReader {
    private Document document;

    public DocumentReader(Document document) {
        this.document = document;
    }

    public static Document createDocument(File file, Logger logger) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(file);
        } catch (Exception ex) {
            logger.errorToConsole(ex.getMessage());
        }
        return null;
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
