package edu.problems.sorting;

/**
 # Time Complexity:
    - Best Case:  O (n log n ) – This occurs when the pivot divides the array into roughly equal parts in
    each step (balanced partitions).
    - Average Case:  O(n log n)
    - Worst Case:  O (n2) – This occurs when the pivot is the smallest or the largest element in the array,
    leading to very skewed partitions. For example, a sorted or reverse-sorted array will often give the
    worst-case behavior with naive pivot selection strategies.

 # Space Complexity:
    Worst Case:  O (log n ) – This accounts for the memory used by the recursion stack. Even though
    Quick Sort is an in-place sorting algorithm and does not use any extra space for the elements
    themselves, the recursive nature of the algorithm means that it uses a stack, and in the worst
    case (for well-balanced partitions), the depth of the recursive call stack is  log n.
 */
public class QuickSort {

    public static void main(String[] args) {
//        int[] arr = {10, 7, 8, 9, 1, 5};
//        quickSort(arr, 0, arr.length - 1);
//        for (int val : arr) {
//            System.out.print(val + " ");
//        }

        System.out.println(maximumSwap(4739));
    }

    public static int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] rightMaxIndices = new int[digits.length];
        rightMaxIndices[digits.length - 1] = digits.length - 1;

        // Create a right-side maximum value index tracker
        for (int i = digits.length - 2; i >= 0; i--) {
            rightMaxIndices[i] = (digits[i] > digits[rightMaxIndices[i + 1]]) ? i : rightMaxIndices[i + 1];
        }

        // Traverse through the digits and try to find the optimal swap
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] < digits[rightMaxIndices[i + 1]]) {
                char temp = digits[i];
                digits[i] = digits[rightMaxIndices[i + 1]];
                digits[rightMaxIndices[i + 1]] = temp;
                break;
            }
        }

        return Integer.parseInt(new String(digits));
    }


    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);  // sort left of pivot
            quickSort(arr, pivot + 1, high); // sort right of pivot
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;  // return the pivot index
    }
}

