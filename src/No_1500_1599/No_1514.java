package No_1500_1599;

import java.util.*;

// No.1514.Path with Maximum Probability
// https://leetcode.com/problems/path-with-maximum-probability
public class No_1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<double[]>[] graph = new LinkedList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = succProb[i];
            graph[from].add(new double[]{(double)to, weight});
            graph[to].add(new double[]{(double)from, weight});
        }
        return dijstra(start_node, end_node, graph);
    }

    class State{
        int id;
        double probFromStart;

        State(int id, double probFromStart){
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }

    private double dijstra(int start, int end, List<double[]>[] graph){
        double[] probTo = new double[graph.length];
        Arrays.fill(probTo, -1.0);
        probTo[start] = 1.0;
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.probFromStart, a.probFromStart);
        });
        pq.offer(new State(start, 1.0));
        while(!pq.isEmpty()){
            State curState = pq.poll();
            int curId = curState.id;
            double curProbFromStart = curState.probFromStart;
            if (curId == end) return curProbFromStart;
            if (curProbFromStart < probTo[curId]) {
                continue;
            }
            for (double[] neighbor: graph[curId]){
                int nextId = (int)neighbor[0];
                double nextProb = probTo[curId] * neighbor[1];
                if (nextProb > probTo[nextId]){
                    probTo[nextId] = nextProb;
                    pq.offer(new State(nextId, nextProb));
                }
            }
        }
        return 0.0;
    }
}
