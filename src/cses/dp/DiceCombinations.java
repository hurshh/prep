//package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiceCombinations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tkn.nextToken());
        int[] dp = new int[n+1];
        dp[0] = 1;


        for(int i=1;i<=n;i++){
            dp[i] = 0;
            for(int j=1;j<=6;j++){
                if(i-j>=0){
                    dp[i] += dp[i-j];
                    dp[i] %= 1000000007;
                }
            }
        }

        System.out.println(dp[n]% 1000000007);
    }
}
