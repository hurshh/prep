package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class MinimizingCoins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tkn.nextToken()), x = Integer.parseInt(tkn.nextToken());
        int[] coins = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int dp[] = new int[x+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i=1;i<=x;i++){
            for(int coin: coins){
                if(i-coin >=0 && dp[i-coin] >= 0){
                    if(dp[i] < 0 ) dp[i] = dp[i-coin]+1;

                    else dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        System.out.println(dp[x]);
    }
}
