package No_500_599;

import java.util.Stack;

// No.503.Next Greater Element II
// https://leetcode.com/problems/next-greater-element-ii
public class No_503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--){
            while(!stk.isEmpty() && stk.peek() <= nums[i % n]) {
                stk.pop();
            }
            res[i % n] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[i % n]);
        }
        return res;
    }
}
