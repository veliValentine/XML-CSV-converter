package app.documentReader;

import app.InvoiceRow;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class RowReader extends DocumentReader{

    public RowReader(Document document){
        super(document);
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
}
