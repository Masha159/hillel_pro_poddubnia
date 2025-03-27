package org.lessons.lesson10.fileLogger;

public class FileLoggerConfiguration {
    LoggingLevel loggingLevel;
    long size;
    String template = "[%s][%s]: %s";
    String fileName;

    FileLoggerConfiguration(){
    }

    public void setLoggingLevel(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
