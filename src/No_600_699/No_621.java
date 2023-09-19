package No_600_699;

import java.util.Arrays;

// No.621.Task Scheduler
// https://leetcode.com/problems/task-scheduler
public class No_621 {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int[26];
        for(char task: tasks){
            taskCounts[task - 'A'] ++;
        }
        Arrays.sort(taskCounts);
        int maxCount = taskCounts[25];
        int idleTime = (maxCount - 1) * n;

        for (int i = 24; i >= 0 && taskCounts[i] > 0; i--){
            idleTime -= Math.min(taskCounts[i], maxCount - 1);
        }
        return idleTime > 0 ? idleTime + tasks.length : tasks.length;
    }
}
