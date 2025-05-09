package org.lessons.lesson19;

import java.util.Arrays;

public class ArrayUtils {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Вхідний масив: " + Arrays.toString(arr));

        mergeSort(arr);

        System.out.println("Відсортований масив: " + Arrays.toString(arr));

        int target = 12;

        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println("Елемент " + target + " знайдено за індексом " + index);
        } else {
            System.out.println("Елемент " + target + " не знайдено у масиві");
        }
    }


    public static void mergeSort(int[] array) {
            sort(array, 0, array.length - 1);
        }


    private static void sort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public static int binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
