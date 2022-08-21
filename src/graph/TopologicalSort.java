package graph;

import java.util.ArrayList;
import java.util.Collections;

public class TopologicalSort {

    public static void addEdge(int a, int b, ArrayList<ArrayList<Integer>> graph){
        graph.get(a).add(b);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<6;i++) graph.add(new ArrayList<>());

        addEdge(2,3,graph);
        addEdge(3,1,graph);
        addEdge(4,1,graph);
        addEdge(4,0,graph);
        addEdge(5,0,graph);
        addEdge(5,2,graph);

        ArrayList<Integer> ans = topSort(6,graph);

        for(int i : ans) System.out.print(i + " ");
        System.out.println();
    }

    public static void dfs(int curr, boolean[] visited, ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> ans){
        visited[curr] = true;

        for(int i : graph.get(curr)){
            if(!visited[i])dfs(i, visited, graph, ans);
        }

        ans.add(curr);
    }

    public static ArrayList<Integer> topSort(int nodes, ArrayList<ArrayList<Integer>> graph){
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[nodes];

        for(int i=0;i< nodes;i++){
            if(!visited[i]){
                dfs(i,visited, graph, answer);
            }
        }

        Collections.reverse(answer);

        return answer;
    }
}
