package No_600_699;
// No.695.Max Area of Island
// https://leetcode.com/problems/max-area-of-island
public class No_695 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) return 0;
        if (grid[i][j] == 0) return 0;
        // Error marker in 16/09/2023
        grid[i][j] = 0;
        return dfs(grid, i + 1, j) + dfs(grid, i  - 1, j) +
                dfs(grid, i, j + 1) + dfs(grid, i, j - 1) + 1;
    }

}
