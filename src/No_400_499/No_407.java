package No_400_499;

import java.util.PriorityQueue;

// No.407 Trapping Rain Water II
// https://leetcode.com/problems/trapping-rain-water-ii
public class No_407 {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1){
                    pq.offer(new int[]{heightMap[i][j], 1, j});
                    visited[i][j] = true;
                }
            }
        }

        int res = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!pq.isEmpty()){
            int[] curr_min = pq.poll();
            for (int k = 0; k < 4; k++){
                int x = curr_min[1] + dirs[k][0];
                int y = curr_min[2] + dirs[k][1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]){
                    res += Math.max(0, curr_min[0] - heightMap[x][y]);
                    visited[x][y] = true;
                    pq.offer(new int[]{Math.max(curr_min[0], heightMap[x][y]), x, y});
                }
            }
        }
        return res;
    }
}
