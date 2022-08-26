package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class _48_RotateArray {
    public static void main(String[] args) {

    }

    static void reverse(int a[], int n)
    {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0;i <n/2;i++){
            for(int j=0; j<n;j++){
                swap(i,j,matrix);
            }
        }

        for(int[] arr: matrix) reverse(arr, n);

    }


    public static void swap(int i, int j, int[][] matrix){
        int c = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = c;
    }
}
