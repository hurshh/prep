package leetcode;

import java.util.Arrays;

public class _673_NumberOfLIS {
    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1,3,5,4,7}));
    }

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n], count = new int[n];
        Arrays.fill(dp,1); Arrays.fill(count,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]+1 == dp[i]) count[i] += count[j];

                    if(dp[j]+1 > dp[i]){
                        count[i] = count[j];
                        dp[i] = dp[j]+1;
                    }

                }
            }
        }

        int max = 0,ans =0;
        for(int i: dp) max=Math.max(i,max);

        for(int i=0;i<n;i++){
            if(dp[i]==max) ans = count[i];
        }

        return ans;
    }
}
