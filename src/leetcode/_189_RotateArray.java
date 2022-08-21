package leetcode;

public class _189_RotateArray {
    public static void main(String[] args) {

    }
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if(k>0){
            int start = 0, end = len -1;
            while (start<end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
            start = 0;end = k-1;
            while (start<end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
            start = k;end = len-1;
            while (start<end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }

    }
}
