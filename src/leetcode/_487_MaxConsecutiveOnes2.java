package leetcode;

public class _487_MaxConsecutiveOnes2 {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxTillNow =0, ans=0, indexOfLastZero = -1;
        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                maxTillNow++;
            }
            else {
                maxTillNow = i-indexOfLastZero;
                indexOfLastZero = i;
            }
            ans = Math.max(ans, maxTillNow);
        }
        return ans;
    }

}
