package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountingTowers {
    public static void main(String[] args) throws IOException {
        int MOD =  1000000007;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(tkn.nextToken());
        long[] dp = new long[1000001];
        dp[1] = 2;
        dp[2] = 8;

        for(int i=3;i<1000001;i++) dp[i] = ((6*dp[i-1] - 7*dp[i-2]) % MOD + MOD) % MOD;

        while (t-- >0){
            tkn = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tkn.nextToken());

            System.out.println(dp[n]);
        }
    }
}
