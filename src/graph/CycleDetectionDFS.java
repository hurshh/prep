package graph;

import java.util.ArrayList;

public class CycleDetectionDFS {
    public static void main(String[] args) {
        GraphInput input = new GraphInput();
        ArrayList<ArrayList<Integer>> graph = input.input();
        System.out.println(isCycle(8,graph));
    }

    public static boolean checkForCycle(int node, int parent,boolean[] visited,ArrayList<ArrayList<Integer>> graph){
        visited[node] = true;
        for(int i: graph.get(node)){
            if(!visited[i]){
                if(checkForCycle(i,node,visited,graph)) return true;
            }
            else if (i != parent){
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(int vertex, ArrayList<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[vertex];
        for(int i=0;i<vertex;i++){
            if(!visited[i]){
                if(checkForCycle(i,-1,visited,graph)) return true;
            }
        }
        return false;
    }
}
