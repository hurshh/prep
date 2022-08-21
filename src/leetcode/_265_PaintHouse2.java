package leetcode;
import java.util.Arrays;

public class _265_PaintHouse2 {
    public static void main(String[] args) {
        int[][] cost = {{1,5,3},{2,9,4}};
        int[][] cost2 = {{1,3}};
        System.out.println(minCostII(cost2));
    }

    public static int minCostII(int[][] costs) {
        int n = costs.length;
        int m = costs[0].length;
        int[][] dp = new int[n+1][m+1];

        Arrays.fill(dp[0],0);
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int min = Integer.MAX_VALUE;
                for(int k=1;k<=m;k++){
                    if(k != j){
                        min = Math.min(min, dp[i-1][k]);
                    }
                }
                dp[i][j] = costs[i-1][j-1] + min;
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=m;i++){
            ans = Math.min(ans,dp[n][i]);
        }
//        for(int[] arr : dp){
//            for(int i: arr){
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }

        return ans;
    }
}

