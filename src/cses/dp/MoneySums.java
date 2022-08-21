package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class MoneySums {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tkn.nextToken());
        int[] coins = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[n+1][n+1];

        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(int coin: coins){
            ArrayList<Integer> ans = new ArrayList<>();
                for (int i:set){
                    ans.add(coin+i);
                }
            set.addAll(ans);
        }

        set.remove(0);

        System.out.println(set.size());
        ArrayList<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        for(int i: ans) System.out.print(i+" ");
        System.out.println();
    }
}
