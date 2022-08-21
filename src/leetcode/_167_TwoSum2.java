package leetcode;

public class _167_TwoSum2 {
    public static void main(String[] args) {
        int[] numbers = {-1,0};
        int[] ans = twoSum(numbers , -1);
        System.out.println(ans[0]+" "+ ans[1]);
    }
    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length,secondNumber= -1;
        int[] ans = new int[2];
        for(int i=0;i< len;i++){
            int RemainingSum = target-numbers[i];
            int leftIndex = i+1, rightIndex = len-1, mid;
            while(leftIndex<=rightIndex){
                mid = leftIndex + (rightIndex-leftIndex)/2;
                if(numbers[mid] == RemainingSum){
                    secondNumber = mid;
                    break;
                }
                else {
                    if(numbers[mid] > RemainingSum){
                        rightIndex = mid-1;
                    }
                    else {
                        leftIndex = mid+1;
                    }
                }
            }

            if(secondNumber != -1){
                ans[0] = i+1;
                ans[1] = secondNumber+1;
                break;
            }
        }
        return ans;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int a = 0;
        int b = numbers.length -1;
        while (numbers[a] + numbers[b] != target) {
            if (numbers[a] + numbers[b] > target) {
                b--;
            } else {
                a++;
            }
        }
        return new int[]{a+1,b+1};
    }

}
