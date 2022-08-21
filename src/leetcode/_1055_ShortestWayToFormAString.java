package leetcode;

import java.util.HashSet;

public class _1055_ShortestWayToFormAString {

    public static void main(String[] args) {
        System.out.println(shortestWay("xyz", "xzyxz"));
    }

    public static int shortestWay(String source, String target) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<source.length();i++) set.add(source.charAt(i));

        int index=0,ans =0;
        while (index<target.length()){
            ans++;
            int temp = commonLength(source,target,index,set);
            if(temp == -1) return -1;
            index += temp;
        }
        return ans;
    }

    static int commonLength(String source, String target, int index, HashSet<Character> set){
        int a=0, length=0;

        while (a<source.length()){
            if(!set.contains(target.charAt(index))) return -1;
            if(source.charAt(a) == target.charAt(index)){
                a++;
                index++;
                length++;
            }
            else {
                a++;
            }
        }

        return length;
    }
}
