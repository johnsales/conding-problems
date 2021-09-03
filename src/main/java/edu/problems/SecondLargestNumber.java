package edu.problems;

public class SecondLargestNumber {
    public static void main(String[] args) {
        SecondLargestNumber secondLargestNumber = new SecondLargestNumber();
        int[] array = new int[]{1,2,3,4,5};
        System.out.println(secondLargestNumber.secondlargest(array));
    }

    private int secondlargest(int[] array) {
        if(array.length < 2) throw new IllegalArgumentException("invalid size array");
        int largest = array[0] > array[1] ? array[0] : array[1],secondLargest = array[0] > array[1] ? array[1] : array[0];

        for (int i = 2; i < array.length; i++) {
            if(array[i] > largest){
                secondLargest = largest;
                largest = array[i];
            }else if(array[i] > secondLargest)
                secondLargest = array[i];
        }
        return secondLargest;
    }
}
