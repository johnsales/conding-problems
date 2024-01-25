package edu.problems.interviews.bloomberg;

public class NumberOfShipsInRectangle {
    public static void main(String[] args) {
        //TODO
        System.out.println(countShips(null,null,null));}
    public static int countShips(Sea sea, int[] topRight, int[] bottomLeft) {return 0;}
    interface Sea { public boolean hasShips(int[] topRight, int[] bottomLeft);}
}
