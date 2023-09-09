package No_400_499;

import java.util.HashMap;
import java.util.Stack;

// No.496.Next Greater Element I
// https://leetcode.com/problems/target-sum/
public class No_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        int[] greater = nextGreaterElement(nums2);
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++){
            greaterMap.put(nums2[i], greater[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++){
            res[i] = greaterMap.get(nums1[i]);
        }
        return res;
    }

    private int[] nextGreaterElement(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while(!s.isEmpty() && s.peek() <= nums[i]) s.pop();
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }
}
