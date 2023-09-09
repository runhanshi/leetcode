package No_400_499;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// No.491.Non-decreasing Subsequences
// https://leetcode.com/problems/non-decreasing-subsequences/
public class No_491 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> findSubSequences(int[] nums){
        if (nums.length == 0) return res;
        backtrack(nums, 0);
        return res;
    }

    LinkedList<Integer> track = new LinkedList<>();
    private void backtrack(int[] nums, int start){
        if (track.size() >= 2) {
            res.add(new LinkedList<>(track));
        }
        HashSet<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++){
            if (!track.isEmpty() && track.getLast() > nums[i]) continue;
            if (used.contains(nums[i])) continue;
            used.add(nums[i]);
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}
