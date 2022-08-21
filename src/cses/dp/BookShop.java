package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BookShop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tkn.nextToken()), x = Integer.parseInt(tkn.nextToken());
        int[] price = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] pages = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] dp = new int[n+1][x+1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < x + 1; j++) {
                dp[i][j] = dp[i-1][j];

                if(j >= price[i-1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-price[i-1]] + pages[i-1]);
                }
            }
        }

        System.out.println(dp[n][x]);
    }
}
