package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _368_LargestDivisibleSubSet {
    public static void main(String[] args) {
        List<Integer> temp = largestDivisibleSubset(new int[]{1,2,4,8});
        for(int i:temp) System.out.print(i+" ");
        System.out.println();
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j] == 0) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int max = Integer.MIN_VALUE,index = -1;
        for(int i=0;i<n;i++){
            if(dp[i] > max){
                index = i;
                max = dp[i];
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(nums[index]);
        max--;

        int temp = nums[index];

        for(int i = index-1;i>=0;i--){
            if(dp[i] == max && temp%nums[i] == 0){
                ans.add(nums[i]);
                max--;
                temp = nums[i];
            }
        }

        Collections.reverse(ans);
        return ans;
    }

}
