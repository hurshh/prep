package codeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class _317667_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tkn.nextToken());
        int m = Integer.parseInt(tkn.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<Integer>());

        for(int i=0;i<m;i++){
            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int j=1;j<arr[0];j++){
                graph.get(arr[j]).add(arr[j+1]);
                graph.get(arr[j+1]).add(arr[j]);
            }
        }

        int[] ans= new int[n+1];
        Arrays.fill(ans, 1);
        boolean[] visited = new boolean[n+1];

        for(int i=1;i<=n;i++){

            ArrayList<Integer> temp = new ArrayList<>();
            if(!visited[i]){
                int count = 1;

                Queue<Integer> q=  new LinkedList<>();
                q.add(i);
                visited[i] = true;
                temp.add(i);

                while (!q.isEmpty()){
                    int node = q.poll();
                    for(int it : graph.get(node)){
                        if(!visited[it]){
                            q.add(it);
                            visited[it]  = true;
                            temp.add(it);
                            count++;
                        }
                    }
                }

                for(int tr: temp) ans[tr] = count;
            }
        }

        for(int i=1;i<=n;i++) System.out.print(ans[i]+" ");
        System.out.println();
    }
}


