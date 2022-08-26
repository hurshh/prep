import java.util.*;


public class rough {
    public static int[] dsu;


    public static void main(String args[]){

        HashSet<Integer> set = new HashSet<>();

        int n =10;
        dsu = new int[n+1];
        for(int i=0; i <= n; i++) dsu[i] = i;
        merge(1,2);
        merge(3,4);
        merge(1,5);
        merge(5,6);

        for(int i=1;i<=n;i++) find(i);

        for(int i:dsu) System.out.println(i);
    }

    public static int find(int x)
    {
        return dsu[x] == x ? x : (dsu[x] = find(dsu[x]));
    }
    public static void merge(int x, int y)
    {
        int fx = find(x);
        int fy = find(y);
        dsu[fx] = fy;
    }


}


