package leetcode;

public class _977_SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        int[] ans = sortedSquares(nums);

        for(int i: ans){
            System.out.print(i + " ");
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int len = nums.length, left=0, right =0,index =0,min = Integer.MAX_VALUE;
        int[] answer = new int[len];
        for(int i=0;i<len;i++){
            if(Math.abs(nums[i])<min){
                left =i; right=i;
                min = Math.abs(nums[i]);
            }
        }
        answer[index++] = nums[left]*nums[left];
        left--;
        right++;
        while (left>=0 || right<len){
            if(left>=0 && (right >=len || Math.abs(nums[left])<=nums[right])){
                answer[index++] = nums[left]*nums[left];
                left--;
            }

            if(right<len && (left <0 || nums[right]<Math.abs(nums[left]))){
                answer[index++] = nums[right]*nums[right];
                right++;
            }
        }
        return answer;
    }
}
