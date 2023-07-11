package edu.problems.cracking_code_interview.chapter1;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.util.Arrays;
import java.util.Random;

public class RotateMatrix {
    public static void main(String[] args) {
        int row = 3, column = 3;
        int[][] matrix = new int[row][column];

        //fulfill the matrix
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                matrix[r][c] = new Random().nextInt(11);
            }
        }


        System.out.println("Matrix before rotation");
        printMatrix(matrix);

        rotateMatrixV2(matrix);

        System.out.println("\nMatrix after rotation");
        printMatrix(matrix);
    }



    //O(n2) for time and space by John
    static int[][] rotateMatrixV1(int row, int column,int[][] matrixA){
        if(matrixA.length == 0 || matrixA.length != matrixA[0].length) throw new IllegalArgumentException("Invalid Matrix");
        int[][] matrixB = new int[row][column];
        for (int c = 0; c < column; c++) {
            for (int rB = 0, rA = row -1; rB < row; rB++, rA--) {
                matrixB[c][rB] = matrixA[rA][c];
            }
        }
        return matrixB;
    }

    //O(n2) for time by the Book
    static boolean rotateMatrixV2(int[][] matrix){
        if(matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n -1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];//save top

                //left -> top
                matrix[first][i] = matrix[last-offset][first];

                //bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];

                //right -> bottom
                matrix[last][last-offset] = matrix[i][last];

                //top -> right
                matrix[i][last] = top;//right <- saved top
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
