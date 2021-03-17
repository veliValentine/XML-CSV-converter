package app;

import app.documentReader.DocumentReader;
import app.documentReader.InvoiceRowReader;
import app.fileManipulation.FileReader;
import app.fileManipulation.FileWriter;
import app.modules.InvoiceDetailRow;
import org.w3c.dom.Document;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        FileReader fileReader = new FileReader(logger);
        Document document = DocumentReader.createDocument(fileReader.readXML(), logger);
        InvoiceRowReader rowReader = new InvoiceRowReader(document);

        StringBuilder sb = new StringBuilder();
        ArrayList<InvoiceDetailRow> rows = rowReader.getInvoiceRows();
        for (InvoiceDetailRow row : rows) {
            sb.append(row.toCSVRow());
        }

        FileWriter fileWriter = new FileWriter(logger);
        fileWriter.writeToCSV(sb.toString());
    }
}

/*StringBuilder sb = new StringBuilder();

        java.InvoiceRow row = new java.InvoiceRow();
        System.out.println(row.toCSVRow());

        sb.append(getData("InvoiceTypeCode", document) + ";");
        System.out.println("GET CURRENCY");
        sb.append(getData("BuyerPartyIdentifier", document) + ";");
        sb.append(getData("BuyerOrganisationName", document) + ";");
        sb.append(getData("PaymentOverDueFinePercent", document) + ";");
        sb.append(getData("InvoiceDate", document) + ";");
        System.out.println("***CONVERT TO dd.mm.yyyy***");
        sb.append(getData("DeliveryOrganisationName", document) + ";");
        sb.append(getData("DeliveryStreetName", document) + ";");
        sb.append(getData("DeliveryTownName", document) + ";");
        sb.append(getData("DeliveryPostCodeIdentifier", document) + ";");
        sb.append(getData("CountryCode", document) + ";");
        sb.append(getData("InvoiceFreeText", document) + ";");
        System.out.println("---");
        System.out.println(sb.toString());
        writeToCSV(row.toCSVRow());*/