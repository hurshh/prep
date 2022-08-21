package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteGraphDFS {

    public static void main(String[] args) {
        GraphInput input = new GraphInput();
        ArrayList<ArrayList<Integer>> graph = input.input();
        System.out.println(isBipartite(graph,8));
    }

    static boolean BipartiteDfs(ArrayList<ArrayList<Integer>> graph,int parent, int node, int[] color){
        if(parent == -1) color[node] = 1;
        else color[node] = color[parent]^1;
        for(int i: graph.get(node)){
            if(color[i] == -1){
                if(!BipartiteDfs(graph,node,i,color)) return false;
            }
            else if(parent != -1 &&  color[i] == color[node]){
                return false;
            }
        }
        return true;
    }

    static boolean isBipartite(ArrayList<ArrayList<Integer>> graph, int vertex){
        int[] color = new int[vertex];
        Arrays.fill(color, -1);

        for(int i=0;i<vertex;i++){
            if(color[i] == -1){
                if(!BipartiteDfs(graph,-1,i,color)) return false;
            }
        }

        return true;
    }
}
