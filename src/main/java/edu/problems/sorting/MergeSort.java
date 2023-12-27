package edu.problems.sorting;

import java.util.Arrays;

/**
 Time complexity: O(n log n)
 Space Complexity: O(n) – This is due to the auxiliary space used for the merging process.
                          In the worst case, Merge Sort will require space for n elements.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr);
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;  // Array is trivially sorted

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // While there are elements in both arrays
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements if any
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

}

