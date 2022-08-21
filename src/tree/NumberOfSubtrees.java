package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfSubtrees {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<=7;i++) graph.add(new ArrayList<>());

        addEdge(0,1,graph);
        addEdge(0,2,graph);
        addEdge(1,3,graph);
        addEdge(1,4,graph);
        addEdge(1,5,graph);
        addEdge(3,6,graph);
        addEdge(3,7,graph);

        int[] subtrees = numberOfSubtrees(graph);
    }



    public static void SubtreeDFS(int current, int parent, int[] count, ArrayList<ArrayList<Integer>> graph){
        for(int i: graph.get(current)){
            if(i==parent) continue;

            SubtreeDFS(i,current,count,graph);
            count[current] += count[i];
        }

    }

    public static int[] numberOfSubtrees(ArrayList<ArrayList<Integer>> graph){
        int[] subtrees = new int[graph.size()];
        Arrays.fill(subtrees, 1);

        SubtreeDFS(0,-1, subtrees, graph);

        return subtrees;
    }

    public static void addEdge(int a, int b, ArrayList<ArrayList<Integer>> graph){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
}
