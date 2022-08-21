package leetcode;

public class _53_MaximumSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0], currentSum = nums[0];
        for(int i=1; i< nums.length;i++){
            if(currentSum<0) currentSum =0;
            currentSum += nums[i];
            if(currentSum>maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

}
