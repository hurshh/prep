package leetcode;

public class _746_MinCostClimbing {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+2];
        dp[0] = 0;
        dp[1] = cost[0];
        dp[n+1] = 0;
        for(int i=2;i<=n+1;i++){
            if(i != n+1) dp[i] = cost[i-1];
            dp[i] += Math.min(dp[i-1], dp[i-2]);
        }
//        for(int i: dp) System.out.print(i+ " ");

        return dp[n+1];
    }
}
