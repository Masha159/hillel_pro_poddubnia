package org.lessons.lesson16;

public class StringListProcessor {
    static  int countUppercase(String s){
        int counter = 0;
        for (char ch : s.toCharArray()){
            if (Character.isUpperCase(ch)){
                counter++;
            }
        }
        return counter;
    }
}
