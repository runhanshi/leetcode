package No_300_399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// No.399.Evaluate Division
// https://leetcode.com/problems/evaluate-division/
public class No_399 {
    // Input: equations = [["a","b"],["b","c"]],
    // values = [2.0,3.0],
    // queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
    // Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
    private Map<String, Double> value = new HashMap<>();
    private Map<String, Integer> visited = new HashMap<>();
    private Map<String, List<String>> next = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // build graph
        for (int i = 0; i < equations.size(); i++){
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            next.computeIfAbsent(first, k -> new ArrayList<>()).add(second);
            value.put(first +":" + second, values[i]);
            next.computeIfAbsent(second, k -> new ArrayList<>()).add(first);
            value.put(second + ":" + first, 1.0 / values[i]);
            visited.put(first, 0);
            visited.put(second, 0);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++){
            for (String key: visited.keySet()){
                visited.put(key, 0);
            }
            res[i] = dfs(queries.get(i).get(1), queries.get(i).get(0));
        }
        return res;
    }

    private double dfs(String start, String end){
        if (!next.containsKey(start)) return -1.0;
        if (start.equals(end)) return 1.0;

        for (String start_child: next.get(start)){
            if (visited.get(start_child) == 1) continue;
            visited.put(start_child, 1);
            double temp = dfs(start_child, end);
            if (temp != -1.0) {
                return value.get(start_child + ":" + start) * temp;
            }
            visited.put(start_child, 0);
        }
        return -1.0;
    }
}
