package edu.problems.code;

/**
 Find duplicates in the given array?
 in O(n) time

 input: a=[1,1,2]
 output: [1]

 input: a=[9,3,8,9,6,1,2,2]
 output: [9,2]

 #Solution 1:

 - Approach:The elements in the array is from 0 to n-1 and all of them are positive. So to find out the duplicate elements,
 a HashMap is required, but the question is to solve the problem in constant space. There is a catch, the array is of length
 n and the elements are from 0 to n-1 (n elements). The array can be used as a HashMap.
 Problem in the below approach. This approach only works for arrays having at most 2 duplicate elements i.e It will not work
 if the array contains more than 2 duplicates of an element.
 For example: {1, 6, 3, 1, 3, 6, 6} it will give outputas : 1 3 6 6.

 - Note: The above program doesn’t handle 0 cases (If 0 is present in array). The program can be easily modified to handle
 that also. It is not handled to keep the code simple. (Program can be modified to handle 0 cases by adding plus One(+1)
 to all the values. also subtracting One from the answer and by writing { arr [abs(arr[i]) – 1] } in code)
 In other approaches below, solutions are discussed that prints repeating elements only once.
 Algorithm:


 1. Traverse the array from start to end.
 2. For every element,take its absolute value and if the abs(array[i])‘th element is positive, the element has not encountered
 before, else if negative the element has been encountered before print the absolute value of the current element.
 **/
public class FindDuplicates {
    // Function to print duplicates
    void printRepeating(int arr[]) {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < arr.length; i++) {
            int j = Math.abs(arr[i]);
            if (arr[j] >= 0)
                arr[j] = -arr[j];
            else
                System.out.print(j + " ");
        }
    }

    // Driver code
    public static void main(String[] args) {
        FindDuplicates duplicate = new FindDuplicates();
        int arr[] = { 1, 2, 3, 1, 3, 6, 6 };
        duplicate.printRepeating(arr);
    }
}
