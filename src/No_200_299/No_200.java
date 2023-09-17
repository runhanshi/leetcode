package No_200_299;
// No.200.Numbers of Islands
// https://leetcode.com/problems/number-of-islands
public class No_200 {
    public int numIslands(char[][] grid) {
        int res= 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i ,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int col){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;
        if (grid[row][col] == '0') return;
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
