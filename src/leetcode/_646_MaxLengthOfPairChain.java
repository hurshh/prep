package leetcode;

import java.util.Arrays;

public class _646_MaxLengthOfPairChain {
    public static void main(String[] args) {

    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> a[1]-b[1]);

        int ans = 1, len = pairs.length, left = pairs[0][1];

        for(int i =1;i<len;i++){
            if(pairs[i][0]>left){
                ans++;
                left = pairs[i][1];
            }
        }

        return ans;
    }
}
