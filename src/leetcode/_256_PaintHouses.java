package leetcode;

public class _256_PaintHouses {
    public static void main(String[] args) {
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(costs));
        int[][] costs2 = {{7,6,2}};
        System.out.println(minCost(costs2));
    }

    public static int minCost(int[][] costs){
        int len = costs.length;
        int[][] dp = new int[len+1][3];
        for(int i=0;i<3;i++){
            dp[0][i] = 0;
        }
        for(int i=1;i<=len;i++){
            for(int j=0;j<3;j++){
                int TempMin = Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3]);
                dp[i][j] = costs[i-1][j]+TempMin;
            }
        }

        return Math.min(dp[len][0],Math.min(dp[len][1],dp[len][2]));
    }
}
