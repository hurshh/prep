package leetcode;

public class _283_MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {1,3,12,0,0};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length,LeftPointer=0, ZeroesCounter =0;

        for(int i=0;i < len;i++){
            if(nums[i] !=0){
                nums[LeftPointer++] = nums[i];
            }
            else {
                ZeroesCounter++;
            }
        }

        len--;
        while (ZeroesCounter-- > 0){
            nums[len--] = 0;
        }

        for(int i: nums) System.out.print(i + " ");
    }

}
