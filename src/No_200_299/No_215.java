package No_200_299;
import

import java.util.PriorityQueue;
import java.util.Random;

// No.215.Kth Largest Element in an Array
// https://leetcode.com/problems/kth-largest-element-in-an-array
public class No_215 {
    // QuickSelect
    public int findKthLargest_quickSelect(int[] nums, int k){
        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int p = partition(nums, lo, hi);
            if (p == k) {
                return nums[p];
            } else if (p > k){
                hi = p - 1;
            } else {
                lo = p + 1;
            }
        }
        return -1;
    }

    private void shuffle(int[] nums){
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            // rand.nextInt(n-i) 生成[0, n-i) 的随机数
            // i + rand.nextInt(n - i) 生成[i, n)
            int r = i + rand.nextInt(n - i);
            swap(nums, r, i);
        }
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private int partition(int[] nums, int lo, int hi){
        int pivot = nums[lo];
        int i = lo + 1;
        int j = hi;
        while(i <= j){
            while(i <= hi && nums[i] <= pivot) i++;
            while(j > lo && nums[j] > pivot) j--;
            // if (i>= j) break;
            if (i> j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }



    // priorityQueue
    public int findKthLargest_priorityQueue(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int e: nums){
            pq.offer(e);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }

}
