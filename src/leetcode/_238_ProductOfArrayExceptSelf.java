package leetcode;

public class _238_ProductOfArrayExceptSelf {

    public static void main(String[] args) {

    }

    static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroesCount =0;

        for(int i: nums){
            if(i !=0) product *= i;
            else zeroesCount++;
        }

        int[] answer = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            if(zeroesCount == 0){
                answer[i] =product/nums[i];
            }
            else if(zeroesCount == 1){
                if(nums[i]==0) answer[i] = product;
                else answer[i] = 0;
            }
            else answer[i] = 0;
        }

        return answer;
    }
}
