package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {
    public static void main(String[] args) {

    }

    static ArrayList<Integer> dfsOfGraph(int v,ArrayList<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[v];
        ArrayList<Integer> dfs = new ArrayList<>();

        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfsHelper(i,visited,graph,dfs);
            }
        }

        return dfs;
    }

    static void dfsHelper(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> dfs){
        dfs.add(node);
        visited[node] = true;
        for(int it: graph.get(node)){
            if (!visited[it]) dfsHelper(it,visited,graph,dfs);
        }
    }
}
