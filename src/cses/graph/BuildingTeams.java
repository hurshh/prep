package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BuildingTeams {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tkn.nextToken()), m = Integer.parseInt(tkn.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            tkn = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tkn.nextToken()),b= Integer.parseInt(tkn.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] color = new int[n+1];
        Arrays.fill(color,-1);

        for(int i=1;i<=n;i++){
            if(color[i] == -1){
                if(!bfsCheck(graph,i,color)){
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
        }

        StringBuilder res = new StringBuilder();

        for (int i: color){
            if(i == 0) res.append(1).append(" ");

            if(i==1) res.append(2).append(" ");
        }

        System.out.println(res);
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
}
