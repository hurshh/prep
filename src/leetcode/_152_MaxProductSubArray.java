package leetcode;

public class _152_MaxProductSubArray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-4,-3,-2}));
    }

    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int maxSoFar = nums[0], minSoFar = nums[0],ans = nums[0];

        for(int i=1; i<n; i++){
            int curr = nums[i];
            int temp = Math.max(curr, Math.max(curr*maxSoFar, curr*minSoFar));
            minSoFar = Math.min(curr,Math.min(curr*maxSoFar, curr*minSoFar));
            maxSoFar = temp;
            ans = Math.max(ans, maxSoFar);
        }
        return ans;
    }
}
