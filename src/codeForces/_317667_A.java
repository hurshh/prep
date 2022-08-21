package codeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class _317667_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tkn.nextToken());
        int t = Integer.parseInt(tkn.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<Integer>());

        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=0;i<n-1;i++){
            graph.get(i).add(i+arr[i]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        boolean ans = false;

        while (!q.isEmpty()){
            Integer node = q.poll();
            if(node == t-1){
                ans  =true;
                break;
            }

            for(Integer it: graph.get(node)){
                if(!visited[it]){
                    q.add(it);
                    visited[it] = true;
                }
            }
        }

        System.out.println(ans? "Yes" : "No");
    }
}

