package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1182_ShortestDistanceToTargetColor {

    public static void main(String[] args) {
        List<Integer> a = shortestDistanceColor(new int[]{1,1,2,1,3,2,2,3,3},new int[][]{{1,3}});
    }

    public static List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        int n = colors.length;
        int[] dp1 = new int[n], dp2 = new int[n], dp3 = new int[n];
        Arrays.fill(dp1,Integer.MAX_VALUE);
        Arrays.fill(dp2,Integer.MAX_VALUE);
        Arrays.fill(dp3,Integer.MAX_VALUE);

        for(int i=0;i<n;i++){
            if(colors[i] == 1) dp1[i] = 0;
            if(i>0) dp1[i] = Math.min(dp1[i],dp1[i-1]+1);
        }

        for(int i=n-1;i>=0;i--){
            if(colors[i] == 1) dp1[i] = 0;
            if(i<n-1) dp1[i] = Math.min(dp1[i],dp1[i+1]+1);
        }

        for(int i=0;i<n;i++){
            if(colors[i] == 2) dp2[i] = 0;
            if(i>0) dp2[i] = Math.min(dp2[i],dp2[i-1]+1);
        }

        for(int i=n-1;i>=0;i--){
            if(colors[i] == 2) dp2[i] = 0;
            if(i<n-1) dp2[i] = Math.min(dp2[i],dp2[i+1]+1);
        }

        for(int i=0;i<n;i++){
            if(colors[i] == 3) dp3[i] = 0;
            if(i>0) dp3[i] = Math.min(dp3[i],dp3[i-1]+1);
        }

        for(int i=n-1;i>=0;i--){
            if(colors[i] == 3) dp3[i] = 0;
            if(i<n-1) dp3[i] = Math.min(dp3[i],dp3[i+1]+1);
        }

        for(int[] arr: queries){
            if(arr[1] == 1){
                if(dp1[arr[0]]!= Integer.MAX_VALUE-n) answer.add(dp1[arr[0]]);
                else answer.add(-1);
            }
            if(arr[1] == 2){
                if(dp2[arr[0]]!= Integer.MAX_VALUE-n) answer.add(dp2[arr[0]]);
                else answer.add(-1);
            }
            if(arr[1] == 3){
                if(dp3[arr[0]]!= Integer.MAX_VALUE-n) answer.add(dp3[arr[0]]);
                else answer.add(-1);
            }
        }

        return answer;
    }
}
