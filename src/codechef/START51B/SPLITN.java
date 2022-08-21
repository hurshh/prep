package codechef.START51B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SPLITN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(tkn.nextToken());

        while (t -- > 0){
            tkn = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tkn.nextToken());

            int ans = 0;

            String bin = Integer.toBinaryString(n);

            for(int i=0;i<bin.length();i++){
                if(bin.charAt(i) == '1') ans++;
            }

            System.out.println(ans-1);
        }
    }
}
