package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphInput {
    ArrayList<ArrayList<Integer>> input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of vertex");
        int vertex = sc.nextInt();
        System.out.println("enter number of edges");
        int edges = sc.nextInt();
        System.out.println("enter edges");
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<vertex;i++) graph.add(new ArrayList<Integer>());
        for(int i=0;i<edges;i++){
            int e1 = sc.nextInt()-1, e2 = sc.nextInt()-1;
            graph.get(e1).add(e2);
            graph.get(e2).add(e1);
        }

        return graph;
    }

    ArrayList<ArrayList<Integer>> createGraph(int vertex, int edges, boolean directed){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<vertex;i++) graph.add(new ArrayList<Integer>());
        for(int i=0;i<edges;i++){
            int e1 = sc.nextInt()-1, e2 = sc.nextInt()-1;
            graph.get(e1).add(e2);
            if (!directed)graph.get(e2).add(e1);
        }

        return graph;
    }

}
