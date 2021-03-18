package app.documentReader;

import app.Logger;
import app.modules.Address;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DocumentReader {
    private final Document document;
    private Logger logger;

    public DocumentReader(Document document, Logger logger) {
        this.document = document;
        this.logger = logger;
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


    protected String getBillingAddress() {
        Address address = new Address();
        address.setOrganizationName(getTextContent("BuyerOrganisationName"));
        address.setStreet(getTextContent("BuyerStreetName"));
        address.setTown(getTextContent("BuyerTownName"));
        address.setPostalCode(getTextContent("BuyerPostCodeIdentifier"));
        address.setCountry(getTextContent("CountryCode"));
        return address.toString();
    }

    protected String getDeliveryAddress() {
        Address address = new Address();
        address.setOrganizationName(getTextContent("DeliveryOrganisationName"));
        address.setStreet(getTextContent("DeliveryStreetName"));
        address.setTown(getTextContent("DeliveryTownName"));
        address.setPostalCode(getTextContent("DeliveryPostCodeIdentifier"));
        address.setCountry(getTextContent("CountryCode", 1));
        return address.toString();
    }

    protected NodeList getData(String element) {
        try {
            return document.getDocumentElement()
                    .getElementsByTagName(element.trim());
        } catch (Exception ex) {
            logger.errorToConsole(ex.getMessage());
            return null;
        }
    }

    protected String getTextContent(String element) {
        return getTextContent(element, 0);
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
