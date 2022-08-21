package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CycleDetectionBFS {
    public static void main(String[] args) {
        GraphInput gph = new GraphInput();

        ArrayList<ArrayList<Integer>> graph = gph.input();

        System.out.println(cycleDetection(10, graph));
    }




    static boolean cycleDetection(int v, ArrayList<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i]){
                Queue<Node> q = new LinkedList<>();
                visited[i] = true;
                q.add(new Node(i,-1));

                while (!q.isEmpty()){
                    int curr = q.peek().first;
                    int previous = q.peek().second;
                    q.poll();

                    for(int it: graph.get(curr)){
                        if(!visited[it]){
                            q.add(new Node(it,curr));
                            visited[it] = true;
                        }
                        else {
                            if(it != previous) return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}

class Node{
    int first;
    int second;

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}


