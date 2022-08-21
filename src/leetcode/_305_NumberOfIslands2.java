package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _305_NumberOfIslands2 {
    public static void main(String[] args) {

    }

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        IslandDSU dsu = new IslandDSU(n*m);
        List<Integer> ans = new ArrayList<>();

        for(int[] position : positions){
            int r = position[0], c = position[1];
            List<Integer> overlap = new ArrayList<>();


            if (r - 1 >= 0 && dsu.isValid((r-1) * n + c)) overlap.add((r-1) * n + c);
            if (r + 1 < m && dsu.isValid((r+1) * n + c)) overlap.add((r+1) * n + c);
            if (c - 1 >= 0 && dsu.isValid(r * n + c - 1)) overlap.add(r * n + c - 1);
            if (c + 1 < n && dsu.isValid(r * n + c + 1)) overlap.add(r * n + c + 1);

            int index = r * n + c;
            dsu.setParent(index);
            for (int i : overlap) dsu.union(i, index);
            ans.add(dsu.getCount());
        }

        return ans;
    }
}

class IslandDSU {
    int[] parent;
    int[] rank;
    int count;

    IslandDSU(int n){
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 0);
    }


    boolean isValid(int n){
        return parent[n] != -1;
    }

    public int find(int i){
        if (parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx; rank[rootx] += 1;
            }
            --count;
        }
    }

    public void setParent(int i) {
        parent[i] = i;
        ++count;
    }

    public int getCount() {
        return count;
    }
}

