package java.documentReader;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.InvoiceRow;
import java.util.ArrayList;

public class DocumentReader {
    private Document document;

    public DocumentReader(Document document) {
        this.document = document;
    }

    public ArrayList<InvoiceRow> getInvoiceRows() {
        ArrayList<InvoiceRow> rows = new ArrayList<>();
        NodeList invoiceRowElements = getData(InvoiceRowTypes.INVOICE_ROW);
        int rowCount = invoiceRowElements.getLength();
        for (int i = 0; i < rowCount; i++) {
            rows.add(getRowInformation(i));
        }
        return rows;
    }

    private NodeList getData(String element) {
        return document.getDocumentElement()
                .getElementsByTagName(element.trim());
    }

    private InvoiceRow getRowInformation(int i) {
        InvoiceRow row = new InvoiceRow();
        row.setProduct(getTextContent(InvoiceRowTypes.PRODUCT, i));
        row.setProductCode(getTextContent(InvoiceRowTypes.PRODUCT_CODE, i));
        row.setQty(getTextContent(InvoiceRowTypes.QTY, i));
        row.setCurrency(getAttributeValue(
                InvoiceRowTypes.PRICE, i, InvoiceRowTypes.ATTRIBUTE_CURRENCY
        ));
        row.setUnitPriceUnitCode(getAttributeValue(
                InvoiceRowTypes.PRICE, i, InvoiceRowTypes.ATTRIBUTE_PRICE_UNIT
        ));
        row.setUnit(getAttributeValue(
                InvoiceRowTypes.QTY, i, InvoiceRowTypes.ATTRIBUTE_QUANTITY
        ));
        row.setPrice(getTextContent(InvoiceRowTypes.PRICE, i));
        row.setTax(getTextContent(InvoiceRowTypes.VAT, i));
        return row;
    }

    private String getTextContent(String element, int i) {
        return getData(element).item(i).getTextContent();
    }

    private String getAttributeValue(String element, int i, String attribute) {
        return getData(element)
                .item(i)
                .getAttributes()
                .getNamedItem(attribute)
                .getNodeValue();
    }
}
