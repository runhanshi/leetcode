package No_700_799;

import java.util.*;

// No.743.Network Delay Time
// https://leetcode.com/problems/network-delay-time
public class No_743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        // build graph
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++){
            graph[i] = new LinkedList<>();
        }

        for (int[] time: times){
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            graph[from].add(new int[]{to, weight});
        }

        // 计算k到其他节点的最短路径
        int[] distTo = dijkstra(k, graph);
        int res = 0;
        for (int i = 1; i < distTo.length; i++){
            if (distTo[i] == Integer.MAX_VALUE){
                return -1;
            }
            res = Math.max(res, distTo[i]);
        }
        return res;
    }

    class State{
        int id;
        int distFromStart;

        State(int id, int distFromStart){
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    private int[] dijkstra(int start, List<int[]>[] graph){
        int[] distTo = new int[graph.length];
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case
        distTo[start] = 0;
        pq.offer(new State(start, 0));

        while(!pq.isEmpty()){
            State currState = pq.poll();
            int curId = currState.id;
            int curDistFromStart = currState.distFromStart;;
            if (curDistFromStart > distTo[curId]) continue;

            for (int[] neighbor: graph[curId]){
                int nextId = neighbor[0];
                int distToNextNode = distTo[curId] + neighbor[1];
                if(distToNextNode < distTo[nextId]){
                    distTo[nextId] = distToNextNode;
                    pq.offer(new State(nextId, distToNextNode));
                }
            }
        }
        return distTo;
    }
}
