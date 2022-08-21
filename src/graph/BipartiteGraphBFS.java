package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {
    public static void main(String[] args) {
        GraphInput input = new GraphInput();
        ArrayList<ArrayList<Integer>> graph = input.input();
        System.out.println(IsBipartite(8,graph));
    }

    static boolean bfsCheck(ArrayList<ArrayList<Integer>> graph, int node, int[] color){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 1;

        while (!queue.isEmpty()){
            int nde = queue.poll();

            for(int it : graph.get(nde)){
                if(color[it] == -1){
                    color[it] = color[nde] ^ 1;
                    queue.add(it);
                }

                else if(color[it] == color[nde]){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean IsBipartite(int vertex, ArrayList<ArrayList<Integer>> graph){
        int[] color = new int[vertex];
        Arrays.fill(color,-1);

        for(int i=0;i<vertex;i++){
            if(color[i] == -1){
                if(!bfsCheck(graph,i,color)) return false;
            }
        }
        return true;
    }
}
