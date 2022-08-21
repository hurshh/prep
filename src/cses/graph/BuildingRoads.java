package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BuildingRoads {

    public static int[] dsu;

    public static int find(int x)
    {
        return dsu[x] == x ? x : (dsu[x] = find(dsu[x]));
    }
    public static void merge(int x, int y)
    {
        int fx = find(x);
        int fy = find(y);
        dsu[fx] = fy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tkn.nextToken()), m = Integer.parseInt(tkn.nextToken());

        dsu = new int[n+1];
        for(int i=0; i <= n; i++) dsu[i] = i;

        while (m-->0){
            tkn = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tkn.nextToken()), b = Integer.parseInt(tkn.nextToken());
            merge(a,b);
        }


        HashSet<Integer> set = new HashSet<>();

        for(int i=1;i<=n;i++) set.add(find(i));

        int ans = set.size()-1;

        System.out.println(ans);

        if(ans > 0){
            ArrayList<Integer> roads = new ArrayList<>(set);
            StringBuilder res = new StringBuilder();
            for(int i=1;i< roads.size();i++){
                res.append(roads.get(i)).append(" ").append(roads.get(i-1)).append("\n");
            }
            System.out.println(res);
        }
    }


}
