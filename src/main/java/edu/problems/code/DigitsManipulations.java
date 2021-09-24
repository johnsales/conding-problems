package edu.problems.code;

public class DigitsManipulations {
    public static void main(String[] args) {
        DigitsManipulations manipulations = new DigitsManipulations();
        System.out.println(manipulations.calc(1010));//123 = 6-6, 1234 = 24 - 10
    }

    int calc(int number){
        if(number < 1 || number > Math.pow(10, 9)) throw  new IllegalArgumentException("Invalid input");
        return calcProduct(number) - calcSum(number);
    }

    private int calcSum(int number) {
        int result = 0;
        while(number > 0){
            result += number % 10;
            number = number / 10;
        }
        return result;
    }

    private int calcProduct(int number) {
        int result = 1;
        while(number > 0){
            result *= number % 10;
            number = number / 10;
        }
        return result;
    }
}
