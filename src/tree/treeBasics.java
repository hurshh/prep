package tree;

import java.util.ArrayList;

public class treeBasics {
    public static void main(String[] args) {

    }

    public static ArrayList<ArrayList<Integer>> MakeTree(int nodes){
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

        for(int i=0;i<nodes;i++) tree.add(new ArrayList<>());

        return tree;
    }

    public static void makeConnection(int a, int b, ArrayList<ArrayList> tree){
        tree.get(a).add(b);
    }

    public static boolean isValidTreeHelper(int curr, boolean[] visited, ArrayList<ArrayList<Integer>> tree){
        visited[curr] = true;

        for(int i: tree.get(curr)){
            if(!visited[i]) return isValidTreeHelper(i, visited,tree);

            else return false;
        }

        return true;
    }

    public static boolean isValidTree (ArrayList<ArrayList<Integer>> tree){
        int entry = 0;
        boolean[] visited = new boolean[tree.size()];
        int edges = 0;
        for(ArrayList<Integer> edge : tree) edges += edge.size();

        if(edges != tree.size()-1) return false;

        for(int i=0;i<tree.size();i++) if(!visited[i] && isValidTreeHelper(entry, visited, tree)) return false;


        return true;
    }
}
