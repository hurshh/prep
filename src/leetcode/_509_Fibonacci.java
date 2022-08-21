package leetcode;

public class _509_Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(4));

    }
    public static int fib(int n) {
        if(n == 0 || n==1) return n;
        int[] dp = new int[31];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<31;i++){
            dp[i] = dp[i-1]+dp[i-2];
            if(i==n){
                return dp[i];
            }
        }
        return -1;
    }
}
