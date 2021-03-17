package app.fileManipulation;

import app.Logger;

import java.io.File;

public class FileReader {

    private Logger logger;

    public FileReader(Logger logger) {
        this.logger = logger;
    }

    public File readXML() {
        return readXML(FileHelper.RESOURCE_FOLDER + FileHelper.XML_FILE);
    }

    public File readXML(String path) {
        try {
            File file = readFile(path);
            if (!isXML(file)) {
                throw new Exception("File not XML");
            }
            return file;
        } catch (Exception e) {
            logger.errorToConsole(e.getMessage());
        }
        return null;
    }

    public File readFile(String path) {
        try {
            return new File(path);
        } catch (Exception ex) {
            logger.errorToConsole(ex.getMessage());
        }
        return null;
    }

    private boolean isXML(File file) {
        return getFileExtension(file).equals("xml");
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}
