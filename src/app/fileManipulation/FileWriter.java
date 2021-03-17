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
        return writeToCSV(input, fileName, "./");
    }

    public boolean writeToCSV(String input, String fileName, String destinationPath) {
        try (PrintWriter writer = new PrintWriter((destinationPath + fileName + ".csv"))) {
            writer.write(input);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
