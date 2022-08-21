package leetcode;

public class _213_HouseRobber2 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }

    public static int rob(int[] nums){
        int len = nums.length,ans1,ans2;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[len-1];

        for(int i=0;i<len-1;i++){
            dp[i] = nums[i];
            if(i>=2) dp[i] = Math.max(dp[i], nums[i]+dp[i-2]);
            if(i>=3) dp[i] = Math.max(dp[i], nums[i]+dp[i-3]);
        }
        for(int i: dp) System.out.print(i+ " ");
        System.out.println();

        ans1 = Math.max(dp[len-3],dp[len-2]);
        for(int i=0;i<len-1;i++){
            dp[i] = nums[i+1];
            if(i>=2) dp[i] = Math.max(dp[i], nums[i+1]+dp[i-2]);
            if(i>=3) dp[i] = Math.max(dp[i], nums[i+1]+dp[i-3]);
        }
        for(int i: dp) System.out.print(i+ " ");
        System.out.println();

        ans2 = Math.max(dp[len-3],dp[len-2]);

        return Math.max(ans1, ans2);
    }
}
