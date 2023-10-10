package No_300_399;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

// No.347.Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements
public class No_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> valToFreq = new HashMap<>();
        for (int num: nums){
            valToFreq.put(num, valToFreq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((entry1, entry2) -> {
            return entry1.getValue().compareTo(entry2.getValue());
        });
        for (Map.Entry<Integer, Integer> entry: valToFreq.entrySet()){
            pq.offer(entry);
            if (pq.size() > k){
                pq.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--){
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
