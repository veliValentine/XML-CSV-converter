package app.documentReader;

import app.Logger;
import app.modules.InvoiceDetailRow;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class InvoiceRowReader extends DocumentReader {

    public InvoiceRowReader(Document document, Logger logger) {
        super(document, logger);
    }

    public ArrayList<InvoiceDetailRow> getInvoiceRows() {
        ArrayList<InvoiceDetailRow> rows = new ArrayList<>();
        NodeList invoiceRowElements = getData(InvoiceRowTypes.INVOICE_ROW);
        int rowCount = invoiceRowElements.getLength();
        for (int i = 0; i < rowCount; i++) {
            rows.add(getInvoiceRowInformation(i));
        }
        return rows;
    }

    private InvoiceDetailRow getInvoiceRowInformation(int i) {
        InvoiceDetailRow row = new InvoiceDetailRow();
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
}
