package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoSet{
    public static void main(String[] args) throws IOException {
        int mod = 1000000007;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = (n*(n+1))/2;
        if(sum%2 != 0){
            System.out.println(0);
            return;
        }

        sum /= 2;
        int[][] dp = new int[501][sum+1];
        dp[0][0] = 1;

        for(int i=1;i<=500;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j] = dp[i-1][j];
                int left = j-i;
                if (left >= 0) {
                    dp[i][j] += dp[i-1][left];
                    dp[i][j] %= mod;
                }
            }
        }

        System.out.println(dp[n-1][sum]);
    }
}
