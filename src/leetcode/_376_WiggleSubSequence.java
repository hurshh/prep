package leetcode;

public class _376_WiggleSubSequence {
    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
    }

    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] up = new int[n],down = new int[n];
        up[0] = 1; down[0] = 1;

        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                up[i] = up[i-1]+1;
                down[i] = down[i-1];
            }
            if(nums[i] < nums[i-1]){
                down[i] = down[i-1]+1;
                up[i] = up[i-1];
            }
        }

        return Math.max(up[n-1],down[n-1]);
    }
}
