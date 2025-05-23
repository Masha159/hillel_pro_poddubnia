package org.lessons.lesson7;

/**
 * finds a mistake in a word and corrects it
 */
public class Corrector {
    public String handleData(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (String str : strs) {
            for (char c : str.toCharArray()) {
                if (c == 'b') {
                    str = str.replace("b", "o");
                }
            }
            count++;
            stringBuilder.append(count).append(") ").append(str).append("\n");
        }
        return stringBuilder.toString();
    }
}
