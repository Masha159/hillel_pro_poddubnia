package lesson10.fileLogger;

public class Main {
    public static void main(String[] args) {
        FileLoggerConfigurationLoader fileLoggerConfigurationLoader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration fileLoggerConfiguration = fileLoggerConfigurationLoader.load("/Users/maria/Library/Mobile Documents/com~apple~CloudDocs/hillel/hillel_pro_poddubniaa/src/lesson10/fileLogger/LoggerInfo");
        FileLogger fileLogger = new FileLogger(fileLoggerConfiguration);
        fileLogger.info("test");
        fileLogger.debug("test");
    }
}
