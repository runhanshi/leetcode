package No_500_599;

import java.util.Arrays;

// No.517.Super Washing Machines
// https://leetcode.com/problems/super-washing-machines/
public class No_517 {
    public int findMinMoves(int[] machines){
        // 每台洗衣机有三种操作：净输出1，净输入1或2, 净值0
        int n = machines.length;
        int sum = 0;
        for (int machine: machines){
            sum += machine;
        }
        if (sum % n != 0) return -1;
        int avg = sum / n;

        // i 净向左pass多少件
        int[] left = new int[n];
        // i 净向右pass多少件
        int[] right = new int[n];
        Arrays.fill(left, 0);
        Arrays.fill(right, 0);

        // machines[i] - k = left[i] + right[i]
        left[n - 1] = machines[n - 1] - avg;
        right[0] = machines[0] - avg;

        for (int i = 1; i < n; i++){
            left[i] = -right[i - 1];
            right[i] = machines[i] - avg - left[i];
        }

        // 找到总输出最多的,而不是净输出最多的,因为传送带
        int res = 0;
        for (int i = 0; i < n; i++){
            int max_t = 0;
            if (left[i] >= 0) max_t += left[i];
            if (right[i] >= 0) max_t += right[i];
            res = Math.max(res, max_t);
        }
        return res;

    }
}
