package edu.problems.algorithms;

/**
 Theory: This pattern is used to perform the required operation over a 'window' of elements in a larger
 dataset, typically an array or a list, and the window size changes, either increases or decreases, to
 satisfy the problem constraints.

 Pattern: Use two pointers to represent the window's start and end and adjust their positions accordingly.

 Java Example (Maximum sum subarray of size K):
 */
public class SlideWindow {
    public int maxSubArrayOfSizeK(int K, int[] arr) {
        int maxSum = 0, windowSum = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= K - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }
}
