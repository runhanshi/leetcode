package No_700_799;

import java.util.ArrayList;
import java.util.List;

// No.797.All Paths From Source to Target
// https://leetcode.com/problems/all-paths-from-source-to-target
public class No_797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        traverse(graph, res, new ArrayList<>(), 0, visited);
        return res;
    }

    private void traverse(int[][] graph, List<List<Integer>> res, List<Integer> path, int curr, boolean[] visited){
        if (visited[curr]) return;
        path.add(curr);
        if (curr == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        visited[curr] = true;
        for (int w: graph[curr]){
            traverse(graph, res, path, w, visited);
            path.remove(path.size() - 1);
        }
        visited[curr] = false;
    }
}
