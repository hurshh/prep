package leetcode;

public class _42_TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
        int LastMax = Integer.MIN_VALUE, ans =0;

        for(int i: height){
            LastMax = Math.max(LastMax, i);

            ans += LastMax-i;
        }

        return ans;
    }
}
