package org.lessons.lesson10.fileLogger;

import java.util.Objects;

public enum LoggingLevel {
    INFO,
    DEBUG;

    public static LoggingLevel fromString(String stringValue){
        for (LoggingLevel level: LoggingLevel.values()){
            if (Objects.equals(level.toString(), stringValue)){
                return level;
            }
        }
        throw new RuntimeException();
    }
}
