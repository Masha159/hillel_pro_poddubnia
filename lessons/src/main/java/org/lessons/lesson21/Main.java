package org.lessons.lesson21;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class<ArrayUtils> clazz = ArrayUtils.class;
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MethodInfo.class) && method.isAnnotationPresent(Author.class)) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                Author author = method.getAnnotation(Author.class);

                System.out.println("......");
                System.out.println("Method: " + methodInfo.name());
                System.out.println("returnType: " + methodInfo.returnType());
                System.out.println("Description: " + methodInfo.description());
                System.out.println("Author: " + author.firstName() + " " + author.lastName());
                System.out.println("......");

            }
        }
            int[] array1 = {5, 2, 3, 4, 2};
        System.out.println("Sort: " + Arrays.toString(ArrayUtils.sortArray(array1)));
        System.out.println("Сума: " + ArrayUtils.sum(array1));
    }
}
