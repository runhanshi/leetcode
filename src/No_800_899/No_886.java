package No_800_899;

import java.util.LinkedList;
import java.util.List;

// No.886.Possible Bipartition
// https://leetcode.com/problems/possible-bipartition
public class No_886 {
    boolean[] visited;
    boolean[] color;
    boolean res = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        List<Integer>[] graph = buildGraph(n, dislikes);
        for(int i = 1; i < graph.length; i++){
            if (!visited[i]){
                traverse(graph, i);
            }
        }
        return res;
    }

    private List<Integer>[] buildGraph(int n, int[][] dislikes){
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i < n + 1; i++){
            graph[i] = new LinkedList<>();
        }
        for (int[] edge: dislikes){
            int a = edge[0];
            int b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        return graph;
    }

    private void traverse(List<Integer>[] graph, int i){
        if (res == false) return;
        visited[i] = true;
        for(int d: graph[i]){
            if (!visited[d]){
                color[d] = !color[i];
                traverse(graph, d);
            } else {
                if (color[d] == color[i]){
                    res = false;
                    return;
                }
            }
        }
    }
}
