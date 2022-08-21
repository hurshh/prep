package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemovingDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tkn.nextToken());

        int count = 1;

        while (n/10 != 0){
            int subDigit = MaxDigit(n);
            n -= subDigit;

            count++;
        }

        System.out.println(count);
    }

    public static int MaxDigit(int n){
        int digit = 0;

        while (n>0){
            digit = Math.max(digit, n%10);
            n/=10;
        }

        return digit;
    }
}
