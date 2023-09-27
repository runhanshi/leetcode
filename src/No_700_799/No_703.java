package No_700_799;

import java.util.PriorityQueue;

// No.703.Kth Largest Element in a Stream
// https://leetcode.com/problems/kth-largest-element-in-a-stream
public class No_703 {
    class KthLargest {
        private int k;
        private PriorityQueue<Integer> pq = new PriorityQueue<>();

        public KthLargest(int k, int[] nums) {
            for (int e : nums) {
                pq.offer(e);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            this.k = k;
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) pq.poll();
            return pq.peek();
        }
    }
}
