package No_600_699;

import java.util.List;
import java.util.PriorityQueue;

// No.632.Smallest Range Covering Elements from K Lists
// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists
public class No_632 {
    public int[] smallestRange(List<List<Integer>> nums){
        // 初始化结果区间的最小值和最大值
        int min_x = 0;
        int min_y = Integer.MAX_VALUE;
        // 初始化当前窗口的最大值
        int window_max = Integer.MIN_VALUE;
        // next 数组用于存储每个列表当前考虑的元素的索引
        int[] next = new int[nums.size()];
        // 使用优先队列来跟踪当前窗口中的最小值
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(
                (i, j) -> nums.get(i).get(next[i]) - nums.get(j).get(next[j])
        );

        // 初始状态: 将每个列表的第一个元素放入优先队列
        for (int i = 0; i < nums.size(); i++){
            minQueue.offer(i);
            window_max = Math.max(window_max, nums.get(i).get(0));
        }

        for(;;){
            // 从优先队列中取出当前的最小值的来源列表的索引
            int min_i = minQueue.poll();
            // 如果当前区间比已知的最小区间更小，则更新结果区间
            if (window_max - nums.get(min_i).get(next[min_i]) < min_y - min_x){
                min_y = window_max;
                min_x = nums.get(min_i).get(next[min_i]);
            }
            // 移动当前最小值来源列表的指针
            next[min_i]++;
            // 如果一个列表的所有元素都已被考虑过，退出循环
            if (next[min_i] == nums.get(min_i).size()) break;
            // 将新元素放入优先队列
            minQueue.offer(min_i);
            // 更新当前窗口的最大值
            window_max = Math.max(window_max, nums.get(min_i).get(next[min_i]));
        }
        return new int[]{min_x, min_y};
    }
}
