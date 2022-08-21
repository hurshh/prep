package leetcode;

public class _704_BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums,2));

    }
    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int mid = (start+end)/2;
        while (start<end){
            mid = (start+end)/2;

            if(nums[mid]==target) return mid;

            if(nums[mid]<target){
                start = mid+1;
            }

            if(nums[mid]>target){
                end = mid-1;
            }
        }
        return -1;
    }
}
