package app;

import app.documentReader.RowReader;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

    private static String RESOURCE_FOLDER = "src/resource/";
    private static String XML_FILE = "exampleInvoice.xml";
    private static String STYLE_FILE = "styles.xsl";

    public static void main(String[] args) {
        File file = readXML(RESOURCE_FOLDER + XML_FILE);
        Document document = getDocument(file);
        RowReader rowReader = new RowReader(document);

        StringBuilder sb = new StringBuilder();
        ArrayList<InvoiceRow> rows = rowReader.getInvoiceRows();
        for (InvoiceRow row : rows) {
            sb.append(row.toCSVRow());
        }
        System.out.println(sb.toString());
        writeToCSV(sb.toString());
    }


    private static void writeToCSV(String input) {
        try (PrintWriter writer = new PrintWriter((RESOURCE_FOLDER + "test.csv"))) {
            writer.write(input);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void writeToCSV(Document document) {
        File style = readFile(RESOURCE_FOLDER + STYLE_FILE);
        try {
            StreamSource styleSource = new StreamSource(style);
            Transformer transformer = TransformerFactory
                    .newInstance()
                    .newTransformer(styleSource);
            Source source = new DOMSource(document);
            Result outputTarget = new StreamResult(new File(RESOURCE_FOLDER + "x.csv"));
            transformer.transform(source, outputTarget);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Document getDocument(File file) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(file);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private static File readXML(String path) {
        try {
            File file = readFile(path);
            if (!isXML(file)) {
                throw new Exception("NOT XML file");
            }
            return file;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static File readFile(String path) {
        try {
            return new File(path);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private static boolean isXML(File file) {
        return getFileExtension(file).equals("xml");
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        return fileName.substring(fileName.lastIndexOf('.') + 1);
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