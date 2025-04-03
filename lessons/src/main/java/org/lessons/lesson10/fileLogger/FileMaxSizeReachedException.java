package org.lessons.lesson10.fileLogger;

public class FileMaxSizeReachedException extends Throwable {
    String message = "current file size = %s, maximum file size = %s, file path: %s. ";

    public FileMaxSizeReachedException(long fileSize, long maxSize, String path) {
        message = String.format(message, fileSize, maxSize, path);
    }
}
