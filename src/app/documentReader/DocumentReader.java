package app.documentReader;

import app.Logger;
import app.modules.Address;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DocumentReader {
    private final Document document;

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
        return document.getDocumentElement()
                .getElementsByTagName(element.trim());
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
