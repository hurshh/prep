package leetcode;

import java.util.Arrays;

public class _73_SetZeroes {
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length], column = new int[matrix[0].length];

        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            if(row[i] == 1){
                Arrays.fill(matrix[i], 0);
            }
        }

        for(int i=0;i< matrix[0].length;i++){
            if(column[i] == 1){
                for (int j=0;j< matrix.length;j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
