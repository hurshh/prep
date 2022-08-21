package codeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class _1698_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(tkn.nextToken());

        while (t-->0){
            tkn = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tkn.nextToken());
            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            func(n, arr);
        }
    }

    static void func(int n, int[] arr) throws IOException {

        if(n<10){
            HashSet<Integer> st = new HashSet<>();
            for(int i: arr) st.add(i);

            for(int i=0;i<n;i++){
                for(int j=i+1; j<n; j++){
                    for(int k=j+1; k<n; k++){
                        if(!st.contains(arr[i]+arr[j]+arr[k])){
                            System.out.println("No");
                            return;
                        }
                    }
                }
            }

            System.out.println("Yes");
            return;
        }


        System.out.println("No"); return;
    }
}
