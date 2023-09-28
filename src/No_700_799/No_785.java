package No_700_799;
// No.785.Is Graph Bipartite?
// https://leetcode.com/problems/is-graph-bipartite
public class No_785 {
    boolean[] color;
    boolean[] visited;
    boolean res = true;
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        color = new boolean[m];
        visited = new boolean[m];
        for (int i = 0; i < graph.length; i++){
            if (!visited[i]){
                traverse(graph, i);
            }

        }
        return res;
    }

    private void traverse(int[][] graph, int i){
        if (res == false) return;
        visited[i] = true;
        for (int neighbor: graph[i]){
            if (visited[neighbor]) {
                if (color[neighbor] == color[i]) {
                    res = false;
                    return;
                }
            } else {
                color[neighbor] = !color[i];
                traverse(graph, neighbor);
            }

        }
    }
}
