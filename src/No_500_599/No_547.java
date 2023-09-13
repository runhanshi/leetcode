package No_500_599;
// No.547.Number of Provinces
// https://leetcode.com/problems/number-of-provinces/
public class No_547 {
    // dfs
    private boolean[] visited;
    private int[][] g;
    public int findCircleNum(int[][] isConnected){
        g = isConnected;
        int res = 0;
        int n = isConnected.length;
        visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if (!visited[i]) {
                dfs(i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int x){
        visited[x] = true;
        for (int i = 0; i < g.length; i++){
            if(!visited[i] && g[x][i] == 1){
                dfs(i);
            }
        }
    }

    // Union-Find
    // 指向根节点
    private int[] p;
    public int findCircleNum_2(int[][] isConnected){
        int n = isConnected.length;
        p = new int[n];
        for (int i = 0; i < n; i++){
            p[i] = i;
        }
        int res = n;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (isConnected[i][j] == 1){
                    int pa = find(i);
                    int pd = find(j);
                    if (pa != pd){
                        p[pa] = pd;
                        res--;
                    }
                }
            }
        }
        return res;
    }

    private int find(int x){
        if(p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
