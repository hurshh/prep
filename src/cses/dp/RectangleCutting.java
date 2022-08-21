package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RectangleCutting {
    public static void main(String[] args) throws IOException {
        int[][] dp = new int[501][501];
        for(int i=1;i<=500;i++)
            for(int j=1;j<=500;j++){
                if(i==j) dp[i][j] = 0;
                else{
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 1; k < i; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[k][j]+dp[i-k][j]+1);
                    }

                    for (int k = 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[i][j-k]+1);
                    }
                }
            }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());

        System.out.println(dp[Integer.parseInt(tkn.nextToken())][Integer.parseInt(tkn.nextToken())]);
    }
}
