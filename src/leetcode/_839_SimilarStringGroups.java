package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class _839_SimilarStringGroups {
    public static void main(String[] args) {
        System.out.println(numSimilarGroups(new String[]{"omv","ovm"}));
    }

    public static boolean isSimilar(String a, String b){
        int count = 0;
        if(a.length() != b.length()) return false;

        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)) count++;
        }

        if(count != 2) return false;

        return true;
    }

    public static int numSimilarGroups(String[] strs) {
        StringDSU dsu = new StringDSU();

        for(int i=0;i<strs.length;i++){
            for(int j=i+1; j< strs.length;j++){
                if(isSimilar(strs[i], strs[j])) dsu.merge(strs[i], strs[j]);
            }
        }

        HashSet<String> count = new HashSet<>();

        for(String str : strs) count.add(dsu.find(str));


        return count.size();

    }
}
