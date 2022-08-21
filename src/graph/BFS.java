package graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i=0;i<4;i++) g.add(new ArrayList<>());
        System.out.println("enter edges");

        ArrayList<Integer> bfs =  bfsOfGraph(4,g);

        for (int i : bfs) System.out.print(i+" ");
    }


    public static ArrayList<Integer> bfsOfGraph(int v,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i]){

                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;

                while (!q.isEmpty()){
                    Integer node = q.poll();
                    bfs.add(node);

                    for(Integer it: adj.get(node)){
                        if(!visited[it]){
                            q.add(it);
                            visited[it] = true;
                        }
                    }
                }
            }
        }
        return bfs;
    }

}
