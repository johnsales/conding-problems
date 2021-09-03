package edu.problems;

public class DigitsManipulations {
    public static void main(String[] args) {
        DigitsManipulations manipulations = new DigitsManipulations();
        System.out.println(manipulations.calc(1234));//123 = 6-6, 1234 = 24 - 10
    }

    int calc(int number){
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
