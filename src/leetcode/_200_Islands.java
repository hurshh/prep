package leetcode;

public class _200_Islands {
    public static void main(String[] args) {

    }

    public static void dfs(int row, int column, char[][] grid, int NumberOfRows, int NumberOfColumns){
        if(row <0 || column<0 || row >= NumberOfRows || column >= NumberOfColumns || grid[row][column] == '0') return;

        grid[row][column] = '0';

        dfs(row+1,column,grid, NumberOfRows , NumberOfColumns);
        dfs(row-1,column,grid, NumberOfRows , NumberOfColumns);
        dfs(row+1,column+1,grid, NumberOfRows , NumberOfColumns);
        dfs(row+1,column-1,grid, NumberOfRows , NumberOfColumns);

    }

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int NumberOfRows = grid.length;
        int NumberOfColumns = grid[0].length;
        int NumberOfIslands = 0;

        for(int row = 0; row <NumberOfRows; row++){
            for(int column = 0; column <NumberOfColumns; column++){
                if(grid[row][column] == '1'){
                    NumberOfIslands++;
                    dfs(row, column, grid, NumberOfRows, NumberOfColumns);
                }
            }
        }

        return NumberOfIslands;
    }

}
