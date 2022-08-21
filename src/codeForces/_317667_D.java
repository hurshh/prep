package codeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _317667_D {
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

        int[] color = new int[n];
        boolean isBipartite = true;
        Arrays.fill(color, -1);

        for(int i=0;i<n;i++){
            if(color[i] == -1){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 1;

                while (!q.isEmpty()){
                    int node = q.poll();

                    for(int itr : graph.get(node)){
                        if(color[itr] == -1){
                            color[itr] = color[node]^1;
                            q.add(itr);
                        }

                        else if(color[itr] == color[node]){
                            isBipartite = false;
                            break;
                        }
                    }

                    if(!isBipartite) break;
                }
            }
        }

        if(!isBipartite) System.out.println("-1");
        else{

            int zeroes =0;
            for(int i=0;i<n;i++){
                if(color[i] == 0) zeroes++;
            }

            System.out.println(zeroes);
            for(int i=0;i<n;i++){
                if(color[i] == 0) System.out.print((i+1)+" ");
            }
            System.out.println();


            System.out.println(n-zeroes);
            for(int i=0;i<n;i++){
                if(color[i] == 1) System.out.print((i+1)+" ");
            }
            System.out.println();

        }
    }


}
