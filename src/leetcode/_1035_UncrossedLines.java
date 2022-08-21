package leetcode;

import java.util.Arrays;

public class _1035_UncrossedLines {
    public static void main(String[] args) {
        System.out.println(maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
    }

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int dp[][] = new int[n+1][m+1];

        Arrays.fill(dp[0],0);
        for(int[] a: dp) a[0] = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums1[i-1] == nums2[j-1]) dp[i][j] = dp[i-1][j-1] +1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
}
