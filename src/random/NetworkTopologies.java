package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NetworkTopologies {

    public static void main(String[] args) throws IOException {
        int n,m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tkn.nextToken()); m = Integer.parseInt(tkn.nextToken());

        int[] degrees  = new int[n+1];

        for(int i=0;i<m;i++){
            tkn = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tkn.nextToken()), b = Integer.parseInt(tkn.nextToken());
            degrees[a]++;
            degrees[b] ++;
        }

        int c = 2;
        int starDegree = n-1;
        for (int i = 1; i < n+1; i++) {
            if (degrees[i] == 2) {
            } else if (degrees[i] == 1) {
                --c;
            } else if (m == n-1 && degrees[i] == starDegree) {
                System.out.println("star topology");
                return;
            } else {
                System.out.println("unknown topology");
                return;
            }
        }

        System.out.println(c==0 ?  "bus topology" : "ring topology");
    }

}
