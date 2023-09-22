package No_1600_1699;

import java.util.*;

// No.1631.Path With Minimum Effort
// https://leetcode.com/problems/path-with-minimum-effort
public class No_1631 {
    class State{
        int x;
        int y;
        int effortFromStart;

        State(int x, int y, int effortFromStart){
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private List<int[]> adj(int[][] matrix, int x, int y){
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir: dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            neighbors.add(new int[]{nx, ny});
        }
        return neighbors;
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] effortTo = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        effortTo[0][0] = 0;

        Queue<State> pq = new PriorityQueue<>((a,b) -> {
           return a.effortFromStart - b.effortFromStart;
        });
        pq.offer(new State(0, 0, 0));
        while(!pq.isEmpty()){
            State curState = pq.poll();
            int curX = curState.x;
            int curY = curState.y;
            int curEffortFromStart = curState.effortFromStart;

            if (curX == m - 1 && curY == n - 1) return curEffortFromStart;
            if (curEffortFromStart > effortTo[curX][curY]) continue;

            for (int[] neighbor: adj(heights, curX, curY)){
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                int nextEffortFromStart = Math.max(effortTo[curX][curY],
                        Math.abs(heights[curX][curY] - heights[nextX][nextY]));
                if (effortTo[nextX][nextY] > nextEffortFromStart){
                    effortTo[nextX][nextY] = nextEffortFromStart;
                    pq.offer(new State(nextX, nextY, nextEffortFromStart));
                }
            }
        }
        return -1;
    }
}
