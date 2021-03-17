package app;

public class Logger {

    public void logToConsole(String text) {
        System.out.println(text);
    }

    public void errorToConsole(String text) {
        System.out.println("ERROR --- " + text);
    }
}
