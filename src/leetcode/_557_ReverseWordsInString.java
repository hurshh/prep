package leetcode;

import java.util.StringTokenizer;

public class _557_ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        StringBuilder temp = new StringBuilder(s);
        temp.reverse();
        StringTokenizer tkn = new StringTokenizer(temp.toString());
        temp = new StringBuilder();
        while (tkn.hasMoreTokens()){
            temp.insert(0,tkn.nextToken().toString());
            temp.insert(0," ");
        }
        temp.deleteCharAt(0);

        return temp.toString();
    }
}
