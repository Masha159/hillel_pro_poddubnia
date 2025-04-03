package org.lessons.lesson10.fileLogger;

import java.io.*;

public class FileLoggerConfigurationLoader {
    public FileLoggerConfiguration load(String fileName) {
        String line;
        FileLoggerConfiguration configuration = new FileLoggerConfiguration();
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            while ((line = buffer.readLine()) != null) {
                if (line.contains("FILE:")) {
                    configuration.setFileName(line.replace("FILE: ","" ));
                }
                if (line.contains("LEVEL: ")) {
                    configuration.setLoggingLevel(LoggingLevel.fromString(line.replace("LEVEL: ","")));
                }
                if (line.contains("MAX-SIZE: ")) {
                    configuration.setSize(Long.parseLong(line.replace("MAX-SIZE: ","")));
                }
                if (line.contains("FORMAT: ")) {
                    configuration.setTemplate(line.replace("FORMAT: ",""));
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return configuration;
    }
}
