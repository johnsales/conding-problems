package edu.problems.code;

public class isPrimeClass {
    public static void main(String[] args) {
        System.out.println(isPrime(96));
    }

    public static boolean isPrime (int number){
        for (int i = 2; i < Math.sqrt(number); i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
