package cses.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TreeDiameter {
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

        dfs(1,-1, 0, graph);
        dfs(furthest,-1,0,graph);

        System.out.println(diameter);
    }

    public static void dfs(int curr, int parent,int d,ArrayList<ArrayList<Integer>> g){
        if(d> diameter){
            diameter = d;
            furthest = curr;
        }

        for(int i : g.get(curr)){
            if(i != parent) dfs(i, curr,d+1, g);
        }

    }
}
