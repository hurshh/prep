package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class ArrayDescription {
    public static void main(String[] args) throws IOException {
        int mod =  1000000007;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tkn.nextToken());
        int m = Integer.parseInt(tkn.nextToken());

        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[m+1][n+1];

        if(arr[0] == 0){
            for(int[] temp : dp) temp[1] = 1;
        }
        else{
            dp[arr[0]][1] = 1;
        }

        for(int j=2; j<=n; j++){
            if(arr[j-1] == 0) {
                for (int i = 1; i <= m; i++) {
                    if (i > 1) {
                        dp[i][j] += dp[i - 1][j - 1];
                        dp[i][j] %= mod;
                    }

                    dp[i][j] += dp[i][j - 1];
                    dp[i][j] %= mod;

                    if (i < m) {
                        dp[i][j] += dp[i + 1][j - 1];
                        dp[i][j] %= mod;

                    }
                }
            }
            else{
                dp[arr[j-1]][j] += dp[arr[j-1]][j-1];
                dp[arr[j-1]][j] %= mod;

                dp[arr[j-1]][j] += dp[arr[j-1]-1][j-1];
                dp[arr[j-1]][j] %= mod;

                if (arr[j-1] < m) {
                    dp[arr[j-1]][j] += dp[arr[j-1]+1][j-1];
                    dp[arr[j-1]][j] %= mod;
                }
            }
        }

        int ans = 0;

        for(int i=1;i<=m;i++){
            ans += dp[i][n];
            ans %= mod;
        }

        System.out.println(ans);
    }
}
