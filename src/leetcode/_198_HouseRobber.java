package leetcode;

public class _198_HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
    public static int rob(int[] nums) {
        int len = nums.length,ans1,ans2;
        if(len == 1) return nums[0];
        int[] dp = new int[len-1];
        for(int i=0;i<len-1;i++){
            dp[i] = nums[i];
            if(i>=2) dp[i] = Math.max(dp[i], nums[i]+dp[i-2]);
            if(i>=3) dp[i] = Math.max(dp[i], nums[i]+dp[i-3]);
        }
        return Math.max(dp[len-3],dp[len-2]);
    }
}
