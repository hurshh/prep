package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _1048_LongestStringChain {

    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
    }

    public static int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2) -> s1.length() < s2.length() ? -1 : 1);
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        for(int i=1;i< words.length;i++){
            for(int j=0;j<i;j++){
                if(CheckPredecessor(words[i],words[j])){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int ans = -1;
        for(int i:dp) ans = Math.max(i,ans);
        return ans;
    }

    public static boolean CheckPredecessor(String a, String b){
        if(a.length() != b.length()+1) return false;

        int Length2 = b.length(), Length1 = a.length(), indexA =0, indexB = 0;

        while (indexA<Length1 && indexB<Length2){
            if(a.charAt(indexA) == b.charAt(indexB)){
                indexA++;
                indexB++;
            }
            else {
                indexA++;
            }
        }

        if(indexB!= Length2) return false;

        return true;
    }
}
