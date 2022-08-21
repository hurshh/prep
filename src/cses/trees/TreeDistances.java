package cses.trees;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TreeDistances {
    private static int[] ans;
    private static int diameter = -1;
    private static int furthest = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());

        for(int i=0;i<n-1;i++){
            StringTokenizer tkn = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tkn.nextToken()), b = Integer.parseInt(tkn.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        StringBuilder res = new StringBuilder();

        ans = new int[n+1];
        dfs(1,-1, 0, graph);
        dfs(furthest,-1,0,graph);
        dfs(furthest,-1,0,graph);

        for(int i =1; i<=n;i++) res.append(ans[i]).append(" ");
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(res.toString());
        output.flush();
    }

    public static void dfs(int curr, int parent,int d,ArrayList<ArrayList<Integer>> g){
        ans[curr] = Math.max(ans[curr], d);
        if(d> diameter){
            diameter = d;
            furthest = curr;
        }

        for(int i : g.get(curr)){
            if(i != parent) dfs(i, curr,d+1, g);
        }

        ans[curr] = Math.max(ans[curr], d);

    }
}
