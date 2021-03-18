package app;

import app.documentReader.DocumentReader;
import app.documentReader.InvoiceInformationReader;
import app.documentReader.InvoiceRowReader;
import app.fileManipulation.FileReader;
import app.fileManipulation.FileWriter;
import app.modules.InvoiceDetailRow;
import app.modules.InvoiceInformationRow;
import org.w3c.dom.Document;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter path to XML file (optional press enter to continue):");
        String filePath = scanner.nextLine();
        System.out.println("Enter path to destination folder (optional press enter to continue):");
        String outputFolder = scanner.nextLine();
        System.out.println("Enter wanted CSV file name (no extension needed) (optional press enter to continue):");
        String outputName = scanner.nextLine();

        String outPutCSV = readDocumentToCSV(filePath, logger);
        writeToFile(outPutCSV, outputFolder, outputName, logger);
    }

    private static String readDocumentToCSV(String path, Logger logger) {
        FileReader fileReader = new FileReader(logger);
        File xml;
        if (path.isBlank()) {
            xml = fileReader.readXML();
        } else {
            xml = fileReader.readXML(path);
        }
        Document document = DocumentReader.createDocument(xml, logger);

        StringBuilder sb = new StringBuilder();
        InvoiceRowReader rowReader = new InvoiceRowReader(document, logger);
        ArrayList<InvoiceDetailRow> rows = rowReader.getInvoiceRows();
        for (InvoiceDetailRow row : rows) {
            sb.append(row.toCSVRow());
        }

        InvoiceInformationReader informationReader = new InvoiceInformationReader(document, logger);
        InvoiceInformationRow informationRow = informationReader.getInvoiceInformation(rows.get(0).getCurrency());
        sb.insert(0, informationRow.toCSVRow());
        return sb.toString();
    }

    private static void writeToFile(String csv, String folderPath, String fileName, Logger logger) {
        FileWriter fileWriter = new FileWriter(logger);
        boolean isFolder = !folderPath.isBlank();
        boolean isName = !fileName.isBlank();
        if (isFolder && isName) {
            fileWriter.writeToCSV(csv, fileName, folderPath + "/");
            System.out.print("File " + fileName + ".csv found at ");
            System.out.println(folderPath);
            return;
        }
        if (!isName) {
            fileName = "result";
        }
        fileWriter.writeToCSV(csv, fileName);
        System.out.print("File " + fileName + ".csv found at ");
        System.out.println("same folder folder");
    }
}
