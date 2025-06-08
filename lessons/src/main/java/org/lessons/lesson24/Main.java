package org.lessons.lesson24;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Logger loggerFirst = Logger.getInstance();
        Logger loggerSecond = Logger.getInstance();

        loggerFirst.showMessage();
        loggerSecond.showMessage();

        if (loggerFirst == loggerSecond) {
            System.out.println("the check passed");
        }
        else {
            System.out.println("the check failed");
        }
    }
}
