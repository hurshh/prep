package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class CoinCombinations1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tkn.nextToken()), x = Integer.parseInt(tkn.nextToken());
        int[] coins = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long dp[] = new long[x+1];
        dp[0] = 1;

        for(int i=1;i<=x;i++){
            for(int coin : coins){
                if(i-coin >=0){
                    dp[i] += dp[i-coin];
                    dp[i] %= 1000000007;
                }
            }
        }

        System.out.println(dp[x]%1000000007);
    }
}
