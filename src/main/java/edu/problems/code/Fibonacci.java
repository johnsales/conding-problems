package edu.problems.code;

public class Fibonacci {
    public static void main(String[] args) {
        // Given Number N
        int N = 10;

        System.out.println(fibRecursive(N));
        System.out.println(fibIterative(N));
    }

    static int fibRecursive(int number){
        if(number <= 1)
            return number;
        return fibRecursive(number -1) + fibRecursive(number -2);
    }

    static int fibIterative(int number){
        int arrayFib[] = new int[number + 2];
        arrayFib[0] = 0;
        arrayFib[1] = 1;
        for (int i = 2; i <= number; i++) {
            arrayFib[i] = arrayFib[i -1] + arrayFib[i -2];
        }
        return arrayFib[number];
    }
}
