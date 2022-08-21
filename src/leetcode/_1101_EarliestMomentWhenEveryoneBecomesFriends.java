package leetcode;

import java.util.Arrays;

public class _1101_EarliestMomentWhenEveryoneBecomesFriends {
    public static void main(String[] args) {
        System.out.println(earliestAcq(new int[][]{{0,2,0},{1,0,1},{3,0,3},{4,1,2},{7,3,1}},4));
    }

    public static int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a,b) -> a[0]-b[0]);

        DSU dsu = new DSU(n);
        int Time = Integer.MIN_VALUE;

        for(int[] log : logs){
            if(dsu.find(log[1]+1) != dsu.find(log[2]+1)){
                Time = Math.max(Time, log[0]);
            }

            dsu.merge(log[1]+1, log[2]+1);
        }

        int parent = dsu.find(1);
        boolean AreAllAcquainted = true;

        for(int i=1;i<=n;i++){
            if(dsu.find(i) != parent) {
                AreAllAcquainted = false;
                break;
            }
        }
        return AreAllAcquainted ? Time : -1;
    }
}
