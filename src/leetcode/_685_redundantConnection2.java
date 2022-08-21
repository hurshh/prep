package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _685_redundantConnection2 {
    public static void main(String[] args) {

        int[] ans = findRedundantDirectedConnection(new int[][]{{1,2},{2,3},{3,4},{4,1},{1,5}});
        System.out.println(ans[0] + " " +ans[1]);
    }

    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int[] ans = new int[2];

        // check for 2 parents case

        boolean is2p = false; int i2p = -1;

        HashSet<Integer> set = new HashSet();
        for(int[] edge: edges){
            if(set.contains(edge[1])){
                is2p = true;
                i2p = edge[1];
            }

            set.add(edge[1]);
        }

        DSU dsu = new DSU(edges.length);

        if(!is2p){
            for(int[] edge: edges){
                if(dsu.find(edge[0]) == dsu.find(edge[1])){
                    return edge;
                }

                dsu.merge(edge[0], edge[1]);
            }
        }

        else {
            boolean foundOnce = false;

            for(int[] edge: edges){
                if(foundOnce && edge[1] == i2p) return edge;

                if(edge[1] == i2p){
                    foundOnce = true;
                }

            }
        }
        return ans;
    }

}



class DSU
{
    public int[] dsu;
    public int[] size;

    public DSU(int N)
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
