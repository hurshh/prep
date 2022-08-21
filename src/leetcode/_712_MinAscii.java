package leetcode;

import java.util.Arrays;

public class _712_MinAscii {
    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("delete","leet"));
    }

    public static int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(),m = s2.length();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        int sum1=0,sum2=0;
        int[][] dp = new int[n+1][m+1];
        Arrays.fill(dp[0],0);
        for(int[] a:dp) a[0] = 0;

        for(int i=0;i<n;i++) {
            arr1[i] = s1.charAt(i);
            sum1 += arr1[i];
        }

        for(int i=0;i<m;i++) {
            arr2[i] = s2.charAt(i);
            sum2 += arr2[i];
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr1[i-1] == arr2[j-1]) dp[i][j] = dp[i-1][j-1] + arr1[i-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return (sum1-dp[n][m])+(sum2-dp[n][m]);
    }
}
