package org.lessons.lesson24;

public class Logger {
    private static Logger instance;
    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    public void showMessage() {
        System.out.println("Hello, I am a Singleton instance!");
    }


}
