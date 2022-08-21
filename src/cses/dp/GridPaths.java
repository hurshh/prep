package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class GridPaths {
    public static void main(String[] args) throws IOException {
        long mod = (long) (Math.pow(10,9)+7);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tkn.nextToken());
        long[][] dp = new long[n+1][n+1];
        char[][] arr = new char[n][n];
        for(int i=0;i<n;i++) arr[i] = br.readLine().toCharArray();
        dp[1][1] = 1;

        if(arr[0][0] == '*') {
            System.out.println(0);
            return;
        }

        for(int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if(i==1 && j==1) continue;

                if(arr[i-1][j-1] == '.'){
                    dp[i][j] = (dp[i][j-1]%mod) + (dp[i-1][j]%mod);
                    dp[i][j] %= mod;
                }
            }
        }

        System.out.println(dp[n][n]);
    }
}
