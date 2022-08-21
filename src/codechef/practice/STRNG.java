package codechef.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class STRNG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(tkn.nextToken());
        while (t-->0){
            tkn = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tkn.nextToken());
            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] dp = new int[n];

            Arrays.sort(arr);
            Arrays.fill(dp,1);
            for(int i=1;i<n;i++){
                for(int j=0;j<i;j++){

                }
            }
        }
    }

    static int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }
}
