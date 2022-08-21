package cp.DP;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        System.out.println(lcs("ezupkr","ubmrapg"));
    }

    public static int lcsRecursive(String a, String b,int i, int j){
        if(i == a.length() || j==b.length()) return 0;

        else if(a.charAt(i) == b.charAt(j)) return 1+lcsRecursive(a,b,i+1,j+1);

        else return Math.max(lcsRecursive(a,b,i+1,j), lcsRecursive(a,b,i,j+1));
    }

    public static int lcs(String text1, String text2){
        int n = text1.length(),m = text2.length();

        int dp[][] = new int[n+1][m+1];
        Arrays.fill(dp[0],0);
        for(int i =0; i<=n;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

//        for (int[] a: dp){
//            for(int i : a) System.out.print(i+" ");
//            System.out.println();
//        }
//        System.out.println();

        return dp[n][m];
    }
}
