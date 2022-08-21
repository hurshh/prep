package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine(), str2 = br.readLine();

        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<=str1.length();i++) dp[i][0] = i;
        for(int i=0;i<=str2.length();i++) dp[0][i] = i;

        for(int i=1;i<=str1.length();i++)
            for (int j = 1; j <= str2.length(); j++) {
                dp[i][j] = str1.charAt(i-1) == str2.charAt(j-1) ? dp[i-1][j-1] : Math.min(dp[i-1][j],Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
            }

        System.out.println(dp[str1.length()][str2.length()]);
    }
}
