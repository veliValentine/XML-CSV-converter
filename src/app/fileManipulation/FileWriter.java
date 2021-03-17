package app.fileManipulation;

import app.Logger;

import java.io.PrintWriter;

public class FileWriter {

    private Logger logger;

    public FileWriter(Logger logger) {
        this.logger = logger;
    }

    public boolean writeToCSV(String input) {
        return writeToCSV(input, FileHelper.CSV_FILE);
    }

    public boolean writeToCSV(String input, String fileName) {
        try (PrintWriter writer = new PrintWriter((FileHelper.RESOURCE_FOLDER + fileName))) {
            writer.write(input);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
