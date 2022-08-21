package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _310_MinimumHeightTree {

    public static void main(String[] args) {
        List<Integer> ans = findMinHeightTrees(4, new int[][]{{1,0}, {1,2}, {1,3}});

        for(int i: ans) System.out.print(i + " ");
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int depth = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for(int i=0;i<n;i++){
            int height = dfs(i,-1,graph);

            if(height == depth){
                ans = new ArrayList<>();
                ans.add(i);
            }
            if(height < depth){
                ans = new ArrayList<>();
                ans.add(i);
            }


        }

        return ans;
    }

    public static int dfs(int cur, int par, ArrayList<ArrayList<Integer>> graph){
        if(graph.get(cur).isEmpty()) return 0;

        int depth = Integer.MIN_VALUE;
        for(int i: graph.get(cur)){
            if(i == par) continue;

            depth = Math.max(depth, dfs(i, cur, graph)+1);
        }

        return depth;
    }
}
