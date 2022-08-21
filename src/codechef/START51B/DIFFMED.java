package codechef.START51B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DIFFMED {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-->0){
            int n = Integer.parseInt(br.readLine());

            StringBuilder res = new StringBuilder();

            int left = 1, right = n;

            for(int i=1;i<=n;i++){
                if(i%2==0)
                    res.append(left++).append(" ");
                else
                    res.append(right--).append(" ");
            }

            System.out.println(res);
        }
    }
}
