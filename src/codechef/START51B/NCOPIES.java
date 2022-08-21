package codechef.START51B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NCOPIES {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder res = new StringBuilder();

        while (t-->0){
            StringTokenizer tkn = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tkn.nextToken()), m = Integer.parseInt(tkn.nextToken());
            String bin = br.readLine();
            int ones = 0, lastOne = -1, lastZERO = -1;

            for(int i =0;i<n;i++) if(bin.charAt(i) == '1') {
                ones++;
                lastOne = i;
            }
            else {
                lastZERO = i;
            }

            if(ones == 0 ){
                res.append(n).append("\n");
                continue;
            }

            if(ones%2 !=0 && m%2 != 0){
                res.append(0).append("\n");
                continue;
            }

            int TempOnes = (ones*3)/2;
            TempOnes = TempOnes%ones;


        }
    }
}
