package org.lessons.lesson10.fileLogger;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class FileLogger {
    FileLoggerConfiguration configuration;
    public FileLogger (FileLoggerConfiguration configuration){
        this.configuration = configuration;
    }
    public void debug(String message) {
        if (configuration.loggingLevel == LoggingLevel.DEBUG) {
            log(message, LoggingLevel.DEBUG);
        }
    }

    public void info(String message) {
        log(message, LoggingLevel.INFO);
    }

    public void log(String message, LoggingLevel level) {
        File file = new File(configuration.fileName + ".txt");
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(String.format(configuration.template, LocalDateTime.now(), level, message)+"\n");
            if (file.length() > configuration.size) {
                throw new FileMaxSizeReachedException(file.length(), configuration.size, file.getPath());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
            //TODO
        } catch (FileMaxSizeReachedException e) {
            System.out.println(e.message);
        }
    }

}
