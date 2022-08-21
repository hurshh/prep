package leetcode;

public class _344_ReverseString {
    public static void main(String[] args) {
        reverseString(new char[] {'h','e','l','l','o'});
    }

    public static void reverseString(char[] s) {
        int left =0 ,right = s.length-1;
        while (left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

        for(char S:s){
            System.out.print(S);
        }
    }
}
