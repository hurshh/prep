package codechef.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class REVSORT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(tkn.nextToken());
        while (t-->0){
            tkn = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tkn.nextToken());
            int x = Integer.parseInt(tkn.nextToken());
            int[] array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            boolean res = true;

            for(int i=0;i<n-1;i++){
                if(array[i]>array[i+1]){
                    if(array[i]+array[i+1]<=x){
                        int temp= array[i];
                        array[i]=array[i+1];
                        array[i+1]=temp;
                    }
                    else{
                        res = false;
                        break;
                    }
                }
            }

            System.out.println(res ? "Yes" : "No");
        }
    }
}
