package leetcode;

import java.util.Arrays;

public class _1746_MaxSubArraySumWithOneOperation {
    public static void main(String[] args) {
        System.out.println(maxSumAfterOperation(new int[]{2,-1,-4,-3}));
    }

    public static int maxSumAfterOperation(int[] nums) {
        int ans=0, withOperation =0, withoutOperation =0;
        for(int i : nums){
            withOperation = Math.max(0, Math.max(withoutOperation+(i*i), withOperation+i));
            withoutOperation = Math.max(0, Math.max(withoutOperation+i, i));
            ans = Math.max(ans, withOperation);
        }
        return ans;
    }
}
