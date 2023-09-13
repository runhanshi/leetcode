package No_500_599;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// No.542.01 Matrix
// https://leetcode.com/problems/01-matrix/
public class No_542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        for (int[] row: res){
            Arrays.fill(row, -1);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (mat[i][j] == 0){
                    q.offer(new int[]{i, j});
                    res[i][j] = 0;
                }
            }
        }

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++){
                int nextX = x + dirs[i][0];
                int nextY = y + dirs[i][1];
                if (nextX >= 0 && nextY >= 0 && nextY < n && nextX < m && mat[nextX][nextY] == -1){
                    q.offer(new int[]{nextX, nextY});
                    res[nextX][nextY] = res[x][y] + 1;
                }
            }
        }
        return res;
    }
}
