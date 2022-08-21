package codechef.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t-->0){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int units = p%10;
            int tens = (p/10)%10;
            int hundreds = p/100;

            if (p==10) System.out.println("10");
            else if(tens>=1) System.out.println("-1");
            else if(units + hundreds > 10) System.out.println("-1");
            else System.out.println(units+hundreds);
        }
    }
}
