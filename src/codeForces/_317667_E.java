package codeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _317667_E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tkn.nextToken());
        int m = Integer.parseInt(tkn.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<Integer>());

        for(int i=0;i<m;i++){
            tkn = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(tkn.nextToken())-1;
            int e2 = Integer.parseInt(tkn.nextToken())-1;
            graph.get(e1).add(e2);
            graph.get(e2).add(e1);
        }

        boolean[] visited = new boolean[n];
        boolean ans = true;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                long edges = 0,vertices =0;
                Queue<Integer> q= new LinkedList<>();
                q.add(i);
                visited[i] = true;

                while (!q.isEmpty()){
                    int node = q.poll();
                    vertices++;

                    for(int it: graph.get(node)) {
                        if (!visited[it]) {
                            q.add(it);
                            visited[it] = true;
                        }
                        edges++;
                    }
                }


                if(vertices*(vertices-1) != edges){
                    ans = false;
                    break;
                }
            }
        }

        System.out.println(ans ? "YES" : "NO");
    }
}
