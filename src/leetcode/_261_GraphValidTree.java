package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _261_GraphValidTree {
    public static void main(String[] args) {
        System.out.println(validTree(4, new int[][]{{0,1}, {2,3}}));
    }

    public static boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        for(int[] arr : edges){
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }

        boolean[] visited = new boolean[n];

        if(!visited[0]){
                Queue<Node> q = new LinkedList<>();
                visited[0] = true;
                q.add(new Node(0,-1));

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
                            if(it != previous)return false;
                        }
                    }
                }
        }

        for(boolean b:visited) if(!b) return false;

        return true;
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
