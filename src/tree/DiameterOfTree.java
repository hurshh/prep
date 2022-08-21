package tree;

import java.util.ArrayList;

public class DiameterOfTree {
    private static int diameter = -1;
    private static int furthest = -1;


    public static void addEdge(int a, int b, ArrayList<ArrayList<Integer>> graph){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<=6;i++) graph.add(new ArrayList<>());

        addEdge(0,1,graph);
        addEdge(0,2,graph);
        addEdge(0,3,graph);
        addEdge(1,4,graph);
        addEdge(1,5,graph);
        addEdge(3,6,graph);

        dfs(0,-1, 0, graph);
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
