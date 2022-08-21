package leetcode;

public class _300_LongestIncreasingSubSequence {
    public static void main(String[] args) {
    }

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length,max = 1;
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i=1;i<len;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
