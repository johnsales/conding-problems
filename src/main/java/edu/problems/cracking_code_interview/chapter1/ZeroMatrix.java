package edu.problems.cracking_code_interview.chapter1;

import java.util.Arrays;
import java.util.Random;

public class ZeroMatrix {
    public static void main(String[] args) {
        int row = 3, column = 3;
//        int[][] matrix = new int[row][column];
//
//        //fulfill the matrix
//        for (int r = 0; r < row; r++) {
//            for (int c = 0; c < column; c++) {
//                matrix[r][c] = new Random().nextInt(11);
//            }
//        }
        int[][] matrix = {{2,6,0},{1,2,1},{5,8,7}};

        System.out.println("Matrix before zeroMatrix");
        printMatrix(matrix);

        zeroMatrix(matrix);

        System.out.println("\nMatrix after zeroMatrix");
        printMatrix(matrix);
    }

    static boolean zeroMatrix(int[][] matrix){
        if(matrix.length == 0 || matrix.length != matrix[0].length) return false;
        boolean[] rows = new boolean[matrix.length], columns = new boolean[matrix[0].length];

        //flag the position with 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        //update the matrix accordingly
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        return true;
    }



    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix)
            // converting each row as string and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }
}
