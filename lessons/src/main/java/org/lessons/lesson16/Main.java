package org.lessons.lesson16;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        MathOperation mathOperation = (a, b) -> a + b;
        System.out.println("sum = " + mathOperation.operate(3, 5));

        StringManipulator toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.manipulate("hello world"));

        Function<String, Integer> countUpperCase = StringListProcessor::countUppercase;
        System.out.println(countUpperCase.apply("HeLlo World"));

        RandomNumberSupplier randomNumberSupplier = new RandomNumberSupplier();
        System.out.println("random number: " + randomNumberSupplier.get());
    }
}
