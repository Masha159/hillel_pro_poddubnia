package org.lessons.lesson21;

import java.util.Arrays;

public class ArrayUtils {

    @Author(firstName = "Mariia", lastName = "Poddubnia")
    @MethodInfo(name = "sortArray", returnType = "int[]", description = "Sort an array")
    public static int[] sortArray(int[] array) {
         Arrays.sort(array);
         return array;
    }

    @MethodInfo(name = "sum", returnType = "int", description = "Sum of all elements")
    @Author(firstName = "Mariia",  lastName = "Poddubnia")
    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
