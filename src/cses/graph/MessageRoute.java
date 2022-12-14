package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class MessageRoute {
    static ArrayList[] aa;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        aa = new ArrayList[n];
        for (int i = 0; i < n; i++)
            aa[i] = new ArrayList<Integer>();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            aa[i].add(j);
            aa[j].add(i);
        }
        int[] pp = new int[n];
        Arrays.fill(pp, -1);
        int[] qq = new int[n];
        int head = 0, cnt = 0;
        pp[0] = 0;
        qq[head + cnt++] = 0;
        while (cnt > 0) {
            int i = qq[head++]; cnt--;
            if (i == n - 1) {
                cnt = 0;
                while (i != 0) {
                    qq[cnt++] = i;
                    i = pp[i];
                }
                qq[cnt++] = 0;
                PrintWriter pw = new PrintWriter(System.out);
                pw.println(cnt);
                while (cnt-- > 0)
                    pw.print(qq[cnt] + 1 + " ");
                pw.println();
                pw.close();
                return;
            }
            ArrayList<Integer> adj = aa[i];
            for (int j : adj)
                if (pp[j] == -1) {
                    pp[j] = i;
                    qq[head + cnt++] = j;
                }
        }
        System.out.println("IMPOSSIBLE");
    }

}
