package cses.trees;



import cses.FastScanner;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Subordinates {
    static int[] subordinates;

    public static void main(String[] args) throws IOException {
        FastScanner fs  = new FastScanner();
        int nodes = fs.nextInt();
        int[] edges = new int[nodes-1];
        for(int i=0;i<nodes-1;i++) edges[i] = fs.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=nodes;i++) graph.add(new ArrayList<>());

        for(int i=1;i<nodes;i++){
            graph.get(edges[i-1]).add(i+1);
        }

        subordinates = new int[nodes+1];

        dfs(1,graph);

        StringBuilder res = new StringBuilder();

        for(int i=1;i<=nodes;i++){
            res.append(subordinates[i]).append(" ");
        }
        System.out.println(res);
    }

    public static int dfs(int curr, ArrayList<ArrayList<Integer>> graph){
        if(graph.get(curr).isEmpty()){
            subordinates[curr] = 0;
            return 0;
        }

        int num =0;

        for(int i: graph.get(curr)){
            num += dfs(i, graph)+1;
        }

        subordinates[curr] = num;

        return num;
    }
}

