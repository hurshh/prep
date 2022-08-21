package codechef.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DISTGCD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(tkn.nextToken());
        while (t-->0){
            tkn = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tkn.nextToken());
            int b = Integer.parseInt(tkn.nextToken());
            System.out.println(countDivisors(Math.abs(b-a)));
        }
    }


    static int countDivisors(int n) {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0) {
                if (n / i == i)
                    cnt++;

                else cnt = cnt + 2;
            }
        }
        return cnt;
    }

}
