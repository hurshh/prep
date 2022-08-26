package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class RoundTrip {

    public static int[] dsu;
    public static int[] size;

    public static int find(int x) {
        return dsu[x] == x ? x : (dsu[x] = find(dsu[x]));
    }

    public static void merge(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        size[fy] += size[fx];
        dsu[fx] = fy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tkn.nextToken()), m = Integer.parseInt(tkn.nextToken());
        boolean isCycle = false;
        size = new int[n+1];
        dsu = new int[n+1];
        for(int i=0;i<=n;i++) dsu[i] = i;
        Arrays.fill(size, 1);

        for(int i=0;i<m;i++){
            int a = Integer.parseInt(tkn.nextToken()), b = Integer.parseInt(tkn.nextToken());

            if(find(a) == find(b)) isCycle = true;
            merge(a,b);
        }

        if(isCycle){

        }
    }
}
