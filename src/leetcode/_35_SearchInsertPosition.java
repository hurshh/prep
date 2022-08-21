package leetcode;

public class _35_SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 7));
    }
    public static int searchInsert(int[] nums, int target) {
        int start =0, end = nums.length-1;
        int mid;
        int ans = end;

        if(target>nums[end]) return end+1;
        while (start<=end){
            mid = start + (end-start)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid]>target){
                ans = mid;
                end = mid-1;
            }

            if(nums[mid]<target){
                start = mid+1;
            }
        }
        return ans;
    }
}
