package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountingRooms {

    public static void dfs(int row, int column, char[][] rooms, int n, int m){
        if(row <0 || column<0 || row >= n || column >= m || rooms[row][column] == '#') return;

        rooms[row][column] = '#';

        dfs(row+1, column, rooms, n, m);
        dfs(row-1, column, rooms, n, m);
        dfs(row, column+1, rooms, n, m);
        dfs(row, column-1, rooms, n, m);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tkn.nextToken()), m = Integer.parseInt(tkn.nextToken()), ans = 0, dots = 0;
        char[][] rooms = new char[n][m];
        for(int i=0;i<n;i++){
            String temp = br.readLine();
            for(int j=0;j<m;j++){
                rooms[i][j] = temp.charAt(j);
                if(temp.charAt(j) == '.'){
                    dots++;
                }
            }
        }

        if(dots == n*m){
            System.out.println(1);
            return;
        }

        for(int row = 0; row < n; row++){
            for(int column=0; column < m; column++){
                if(rooms[row][column] == '.'){
                    ans ++;
                    dfs(row,column, rooms, n, m);
                }
            }
        }

        System.out.println(ans);
    }
}
