package No_700_799;

import java.util.Arrays;
import java.util.PriorityQueue;

// No.778.Swim in Rising Water
// https://leetcode.com/problems/swim-in-rising-water
public class No_778 {
    public int swimInWater_dijkstra(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        pq.offer(new int[]{0, 0, grid[0][0]});
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] distTo = new int[n][n];
        for (int[] dist: distTo){
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        distTo[0][0] = grid[0][0];

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int curr_x = curr[0];
            int curr_y = curr[1];
            int currFromStart = curr[2];
            if (currFromStart > distTo[curr_x][curr_y]) continue;
            if (curr_x == n - 1 && curr_y == n - 1) {
                return currFromStart;
            }
            for (int[] dir: dirs){
                int next_x = dir[0] + curr_x;
                int next_y = dir[1] + curr_y;
                if (next_y < 0 || next_x < 0 || next_x >= n || next_y >= n) continue;
                int nextFromStart = Math.max(currFromStart, grid[next_x][next_y]);
                if (nextFromStart < distTo[next_x][next_y]){
                    distTo[next_x][next_y] = nextFromStart;
                    pq.offer(new int[]{next_x, next_y, nextFromStart});
                }
            }
        }
        return -1;
    }

    private int[] p;
    public int swimInWater_unionFind(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        p = new int[size];
        for (int i = 0 ; i < size; i++) {
            p[i] = i;
        }

        int[] hi = new int[size];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                hi[grid[i][j]] = i * n + j;
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < size; i++){

            int row = hi[i] / n;
            int col = hi[i] % n;
            for (int[] dir: dirs){
                int next_row = row + dir[0];
                int next_col = col + dir[1];
                // do not use it; example[[0]]
//                if (next_col < 0 || next_row < 0 || next_col >= n || next_row >= n){
//                    continue;
//                }
                if ( next_col >= 0 && next_row >= 0 && next_col < n && next_row < n && grid[next_row][next_col] <= i) {
                    p[find(next_row * n + next_col)] = find(row * n + col);
                }
                if (find(p[0]) == find(p[size - 1])) return i;
            }
        }
        return -1;
    }

    private int find(int x){
        if (p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
