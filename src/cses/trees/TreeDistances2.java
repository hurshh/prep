package cses.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TreeDistances2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        for(int i=1;i<n;i++){
            StringTokenizer tkn = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tkn.nextToken()), b = Integer.parseInt(tkn.nextToken());

            graph.get(a).add(b);

        }

    }
}
