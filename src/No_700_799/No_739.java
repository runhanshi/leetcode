package No_700_799;

import java.util.Stack;

// No.739.Daily Temperatures
// https://leetcode.com/problems/daily-temperatures
public class No_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--){
            while(!stk.isEmpty() && temperatures[stk.peek()] <= temperatures[i]){
                stk.pop();
            }
            res[i] = stk.isEmpty() ? 0 : stk.peek() - 1;
            stk.push(i);
        }
        return res;
    }
}
