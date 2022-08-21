package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class _1579_MaxNumEdgesToRemove {
    public static void main(String[] args) {
        System.out.println(maxNumEdgesToRemove(4, new int[][]{{3,2,3},{1,1,2},{2,3,4}}));
    }

    public static int maxNumEdgesToRemove(int n, int[][] edges) {

        Arrays.sort(edges, (a,b) -> b[0]-a[0]);
        DSU alice = new DSU(n), bob = new DSU(n);
        int count = 0;

        for(int[] edge : edges){
            if(edge[0] == 1){
                if(alice.find(edge[1]) == alice.find(edge[2])) count ++;

                alice.merge(edge[1],edge[2]);
            }
            else if(edge[0] == 2){
                if(bob.find(edge[1]) == bob.find(edge[2])) count ++;

                bob.merge(edge[1],edge[2]);
            }
            else {
                if((alice.find(edge[1]) == alice.find(edge[2])) && bob.find(edge[1]) == bob.find(edge[2])) count ++;

                alice.merge(edge[1],edge[2]);
                bob.merge(edge[1],edge[2]);
            }
        }

        int aliceParent = alice.find(1), bobParent = bob.find(1);
        boolean traversable = true;

        for(int i=1;i<=n;i++){
            if(alice.find(i) != aliceParent){
                traversable = false;
                break;
            }
            if(bob.find(i) != bobParent){
                traversable = false;
                break;
            }
        }

        return traversable ? count : -1;
    }
}
