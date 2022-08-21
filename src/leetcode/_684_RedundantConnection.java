package leetcode;
import java.util.*;

public class _684_RedundantConnection {
    static Set<Integer> seen = new HashSet();


    public static void main(String[] args) {
        int[] ans = findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}});

        System.out.println(ans[0]+" "+ans[1]);
    }

//    public static int[] findRedundantConnection(int[][] edges) {
//        ArrayList<Integer>[] graph = new ArrayList[1001];
//
//        for(int i=0;i<1001;i++) graph[i] = new ArrayList();
//
//        for(int[] edge: edges){
//            seen.clear();
//
//            if(!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() && dfs(graph, edge[0], edge[1])) return edge;
//
//            graph[edge[0]].add(edge[1]);
//            graph[edge[1]].add(edge[0]);
//        }
//
//        throw new AssertionError();
//    }
//
//    public static boolean dfs(ArrayList<Integer>[] graph, int source, int target){
//        if(!seen.contains(source)){
//            seen.add(source);
//            if(source == target) return true;
//
//            for(int it: graph[source]){
//                if(dfs(graph, it, target)) return true;
//            }
//        }
//
//        return false;
//    }

    public static int[] findRedundantConnection(int[][] edges) {
        DSU1 dsu = new DSU1(edges.length);

        for(int[] edge : edges){
            if(dsu.find(edge[0]) == dsu.find(edge[1])){
                return edge;
            }

            dsu.merge(edge[0],edge[1]);
        }

        return new int[]{-1,-1};
    }
}

class DSU1
{
    public int[] dsu;
    public int[] size;

    public DSU1(int N)
    {
        dsu = new int[N+1];
        size = new int[N+1];
        for(int i=0; i <= N; i++)
        {
            dsu[i] = i;
            size[i] = 1;
        }
    }
    //with path compression, no find by rank
    public int find(int x)
    {
        return dsu[x] == x ? x : (dsu[x] = find(dsu[x]));
    }

    public void merge(int x, int y)
    {
        int fx = find(x);
        int fy = find(y);
        size[fy] += size[fx];
        dsu[fx] = fy;
    }
}

