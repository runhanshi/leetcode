package No_1000_1099;
// No.1004.Max Consecutive Ones III
// https://leetcode.com/problems/max-consecutive-ones-iii
public class No_1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int windowOneCount = 0;
        int res = 0;

        while(right < nums.length){
            if (nums[right] == 1) windowOneCount++;
            right++;

            while(right - left - windowOneCount > k){
                if (nums[left] == 1) windowOneCount--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
