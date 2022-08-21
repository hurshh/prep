package codeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class _1698_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(tkn.nextToken());

        while (t-->0){
            tkn = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(tkn.nextToken()), k = Integer.parseInt(tkn.nextToken());

            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(k==1){
                int ans = (n-1)/2;
                System.out.println(ans);
            }
            else{
                int ans = 0;

                for(int i=1;i<n-1;i++){
                    if(arr[i]> arr[i-1]+arr[i+1]) ans++;
                }

                System.out.println(ans);
            }
        }
    }
}
